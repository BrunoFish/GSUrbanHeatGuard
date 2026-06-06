public class PontoPoligono {
    private int idPonto;
    private RegiaoUrbana regiao;
    private int ordemPonto;
    private double latitude;
    private double longitude;

    public PontoPoligono() {}

    public PontoPoligono(int idPonto, RegiaoUrbana regiao, int ordemPonto, double latitude, double longitude) {
        this.idPonto = idPonto;
        this.regiao = regiao;
        this.ordemPonto = ordemPonto;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdPonto() { return idPonto; }
    public void setIdPonto(int idPonto) { this.idPonto = idPonto; }
    public RegiaoUrbana getRegiao() { return regiao; }
    public void setRegiao(RegiaoUrbana regiao) { this.regiao = regiao; }
    public int getOrdemPonto() { return ordemPonto; }
    public void setOrdemPonto(int ordemPonto) { this.ordemPonto = ordemPonto; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString() {
        return "Ponto " + ordemPonto + " [" + latitude + ", " + longitude + "]";
    }
}