package sam.lambton.tourguidesv20

class SignUpModel {

    val id: Int
    val email: String
    val userType: String
    val password: String

    constructor(id: Int, email: String, userType: String, password: String) {
        this.id = id
        this.email = email
        this.userType = userType
        this.password = password
    }
}