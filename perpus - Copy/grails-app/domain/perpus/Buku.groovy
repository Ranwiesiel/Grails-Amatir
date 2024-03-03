package perpus

class Buku {
    Integer idBuku
    String judul
    String pengarang
    String penerbit
    Date tahunTerbit
    String kategori

    static hasMany = [peminjaman: Peminjaman]

    static constraints = {
    }
}
