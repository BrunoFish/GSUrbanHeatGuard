public class RegiaoUrbana {
    
    // Atributos privados (Encapsulamento - Regra básica de POO)
    private int idRegiao;
    private String nomeLocal;
    private double latitude;
    private double longitude;
    private int raioMetros;

    // Construtor vazio (boa prática)
    public RegiaoUrbana() {
    }

    // Construtor com todos os parâmetros
    public RegiaoUrbana(int idRegiao, String nomeLocal, double latitude, double longitude, int raioMetros) {
        this.idRegiao = idRegiao;
        this.nomeLocal = nomeLocal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.raioMetros = raioMetros;
    }

    // Getters e Setters
    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRaioMetros() {
        return raioMetros;
    }

    public void setRaioMetros(int raioMetros) {
        this.raioMetros = raioMetros;
    }

    // Método toString para facilitar a visualização no console depois
    @Override
    public String toString() {
        return "Regiao: " + nomeLocal + " | Coordenadas: [" + latitude + ", " + longitude + "] | Raio: " + raioMetros + "m";
    }
}