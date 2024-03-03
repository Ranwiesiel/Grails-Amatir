package perpus

class Denda {
    Integer idDenda
    Integer jumlahDenda
    Date jatuhTempo
    String statusDenda

    static belongsTo = [peminjaman: Peminjaman]
    
    static constraints = {
    }
}
