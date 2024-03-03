package perpus

class Petugas {
    Integer idPetugas
    String nama
    String alamat
    String noTelp
    String email

    static hasMany = [peminjaman: Peminjaman]

    static constraints = {
    }
}
