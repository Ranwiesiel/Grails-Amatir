package perpus

class Anggota {
    Integer idAnggota
    String nama
    String alamat
    String noTelp
    String email
    Integer denda

    static hasMany = [peminjaman: Peminjaman]

    static constraints = {
    }
}
