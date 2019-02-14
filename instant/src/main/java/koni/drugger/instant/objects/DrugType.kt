package koni.drugger.instant.objects

import java.util.*

data class DrugType(
    val id: Int,
    val drugName: String,
    val doseRecomended: Double,
    val doseMaxOnce: Double,
    val doseMaxPerDay: Double,
    val doseUnit: String,
    val overdoseSymptoms: String?,
    val overdoseAction: String?,
    val drugEffects: Array<String>,
    val group: String?,
    val contraindications: String?,
    val combinationsGood: Array<Int>,
    val combinationsBad: Array<Int>,
    val banLevel: String?,
    val doseMaxLegal: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DrugType

        if (id != other.id) return false
        if (drugName != other.drugName) return false
        if (doseRecomended != other.doseRecomended) return false
        if (doseMaxOnce != other.doseMaxOnce) return false
        if (doseMaxPerDay != other.doseMaxPerDay) return false
        if (doseUnit != other.doseUnit) return false
        if (overdoseSymptoms != other.overdoseSymptoms) return false
        if (overdoseAction != other.overdoseAction) return false
        if (!Arrays.equals(drugEffects, other.drugEffects)) return false
        if (group != other.group) return false
        if (contraindications != other.contraindications) return false
        if (!Arrays.equals(combinationsGood, other.combinationsGood)) return false
        if (!Arrays.equals(combinationsBad, other.combinationsBad)) return false
        if (banLevel != other.banLevel) return false
        if (doseMaxLegal != other.doseMaxLegal) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + drugName.hashCode()
        result = 31 * result + doseRecomended.hashCode()
        result = 31 * result + doseMaxOnce.hashCode()
        result = 31 * result + doseMaxPerDay.hashCode()
        result = 31 * result + doseUnit.hashCode()
        result = 31 * result + (overdoseSymptoms?.hashCode() ?: 0)
        result = 31 * result + (overdoseAction?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(drugEffects)
        result = 31 * result + (group?.hashCode() ?: 0)
        result = 31 * result + (contraindications?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(combinationsGood)
        result = 31 * result + Arrays.hashCode(combinationsBad)
        result = 31 * result + (banLevel?.hashCode() ?: 0)
        result = 31 * result + (doseMaxLegal?.hashCode() ?: 0)
        return result
    }
}