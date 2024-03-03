package perpus

class Peminjaman {
    Integer idPeminjaman
    Date tglPinjam
    Date tglKembali
    Date tanggalPengembalian
    Integer denda
    String statusPeminjaman

    static hasMany = [denda: Denda]

    static belongsTo = [anggota: Anggota, petugas: Petugas, buku: Buku]

    static constraints = {
    }
}
