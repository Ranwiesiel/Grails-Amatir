class Contact {
    String name
    Integer phoneNumber
    static constraint = {
        name nullable: false
        phoneNumber nullable: false
    }
}