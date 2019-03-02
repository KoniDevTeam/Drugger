package koni.drugger.instant.dbapi

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.fasterxml.jackson.module.kotlin.*
import koni.drugger.instant.objects.DrugType
import org.jetbrains.anko.doAsync
import java.net.URL

const val APP_PREF_NAME = "drugger"
const val LAST_CHANGE_TIME_SHARED_FREF_NAME = "last_change_time"
const val DRUG_DB_JSON_SHARED_FREF_NAME = "drugsjson"

const val API_URL = "http://itgrusha.com/node/junkies/"

private fun getDbChanges(context: Context, timestamp: Long): String {
    val reqsender = HttpReqSender()
    reqsender.execute(API_URL + "db_changes?timestamp=" + timestamp, "GET", "DruggerApp")
    val result = reqsender.get()

    return result
}

fun updateDb(context: Context) {
    val sharedPref = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)
    val timestamp: Long = sharedPref.getLong(LAST_CHANGE_TIME_SHARED_FREF_NAME, 0)

    val dbChangesJson: String = getDbChanges(context, timestamp)

    if (dbChangesJson == "<EXC>")
        return

    val mapper = jacksonObjectMapper()
    val drugsupdate: List<DrugType> = mapper.readValue(dbChangesJson)
    if (drugsupdate.isNotEmpty()) {
        val olddrugs: MutableList<DrugType> = mapper.readValue(sharedPref.getString(DRUG_DB_JSON_SHARED_FREF_NAME, "[]"))

        drugsupdate.forEach { new ->
            var changed = false
            val it = olddrugs.listIterator()
            while (it.hasNext()) {
                if (it.next().id == new.id) {
                    it.set(new)
                    changed = true
                }
            }
            if (!changed)
                olddrugs.add(new)
        }

        val editor = sharedPref.edit()
        editor.putString(DRUG_DB_JSON_SHARED_FREF_NAME, mapper.writeValueAsString(olddrugs))
        editor.putLong(LAST_CHANGE_TIME_SHARED_FREF_NAME, System.currentTimeMillis()/1000)
        editor.apply()
    }
}

fun getAllDrugs(context: Context): List<DrugType> {
    val sharedPref = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)
    return jacksonObjectMapper().readValue(sharedPref.getString(DRUG_DB_JSON_SHARED_FREF_NAME, "[]"))
}

fun getDrug(context: Context, id: Int): DrugType {
    val drugs: List<DrugType> = getAllDrugs(context)
    for (drug in drugs) {
        if (drug.id == id)
            return drug
    }
    throw Resources.NotFoundException(id.toString())
}