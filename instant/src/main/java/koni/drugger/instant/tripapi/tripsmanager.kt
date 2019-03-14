@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package koni.drugger.instant.tripapi

import android.annotation.SuppressLint
import android.content.Context
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import koni.drugger.instant.objects.PlannedTrip
import koni.drugger.instant.objects.TripRule
import java.text.SimpleDateFormat
import java.util.*

val APP_PREF_NAME = "drugger"
val LIST_OF_TRIPS_PREF = "tripsjson"
val LIST_OF_RULES_PREF = "rulesjson"

fun getAllRules(context: Context): List<TripRule> {
    val pref = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)
    val rules: List<TripRule> = jacksonObjectMapper().readValue(pref.getString(LIST_OF_RULES_PREF, "[]"))
    return rules
}

fun getAllTrips(context: Context): List<PlannedTrip> {
    val pref = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)
    val trips: List<PlannedTrip> = jacksonObjectMapper().readValue(pref.getString(LIST_OF_TRIPS_PREF, "[]"))
    return trips
}

private fun calcDateDiff(a: Date, b: Date): Date? {
    return null
}

@SuppressLint("SimpleDateFormat")
fun getTripsOfTheDay(context: Context, date: Date): List<PlannedTrip> {
    val alltrips: List<PlannedTrip> = getAllTrips(context)
    val rules: List<TripRule> = getAllRules(context)

    val trips: MutableList<PlannedTrip> = listOf<PlannedTrip>().toMutableList()

    val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy.MM.dd")

    for (trip in alltrips) {
        var gooddate = false
        for (date_ in trip.dateAndTime) {
            if(dateFormat.format(date_) == dateFormat.format(date)) {
                trips.add(trip)
            }
        }
    }

    for (rule in rules) {
        var diff: Date? = null
        for (date_ in rule.dateAndTimeFrom) {
            val tmp = calcDateDiff(date, date_)
            if (tmp != null)
                diff = tmp
        }
        if (diff != null) {
            trips.add(planTripByRule(context, rule, diff))
        }
    }

    return trips
}

fun getTodayTrips(context: Context): List<PlannedTrip> {
    return getTripsOfTheDay(context, Date())
}

private fun flashTrips(context: Context, trips: List<PlannedTrip>) {

}

private fun flashTripRules(context: Context, rules: List<TripRule>) {

}

private fun planTripByRule(context: Context, rule: TripRule, diff: Date): PlannedTrip {

}

fun planTrip(context: Context, trip: PlannedTrip): PlannedTrip {

}

fun unplanTrip(context: Context, trip: PlannedTrip) {

}

fun addTripRule(context: Context, rule: TripRule): TripRule {

}