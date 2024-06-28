package ro.ccar.demo.app

data class Branches(val branches: List<Branch>) {

    fun getBranchNameByNumber(branchNumber: Int) = branches.firstOrNull { it.number == branchNumber }?.name
}

data class Branch(val number: Int, val location: String, val name: String, val isActive: Boolean, val sourcingEnabled: Boolean?)
