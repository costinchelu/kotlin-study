package ro.ccar.demo.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class DemoKt(private val branches: Branches) {

//    @Autowired
//    private lateinit var branches: Branches

    fun processBranches() {
        val branchList: List<Branch> = branches.branches
        branchList.forEach { println(it)}

        val response: List<Status>? = listOf(
            Status("2", "2024-06-27T08:54:22+00:00"),
            Status("3", "2024-06-27T08:56:22+00:00"),
            Status("1", "2024-06-27T08:53:22+00:00"))

        val responseSortedByDate: List<Status>? = response?.sortedBy { it ->
            it.let {
                it.statusDate?.let { dateString ->
                    ZonedDateTime.parse(dateString).toLocalDateTime()
                }
            }
        }

        val last: Int? = responseSortedByDate?.takeIf { it.isNotEmpty() }?.map { it.node }?.last()?.toIntOrNull()
        val branchNameByNumber: String? = if (last != null) branches.getBranchNameByNumber(last) else "Shop"
        println(branchNameByNumber)
    }
}