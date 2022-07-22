package sam.lambton.tourguidesv20

class PackageModel {

    val id: Int
    val packageName: String
    val packageDescription: String
    val source: String
    val destination: String
    val airline: String
    val hotel: String
    val startDate: String
    val endDate: String

    constructor(id: Int, packageName: String, packageDescription: String, source: String,
    destination: String, airline: String, hotel: String, startDate: String, endDate: String) {
        this.id = id
        this.packageName = packageName
        this.packageDescription = packageDescription
        this.source = source
        this.destination = destination
        this.airline = airline
        this.hotel = hotel
        this.startDate = startDate
        this.endDate = endDate
    }
}