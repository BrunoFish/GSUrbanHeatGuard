import java.time.LocalDateTime;

public class LeituraTermica {
    private int idLeitura;
    private Equipamento equipamento;
    private double temperaturaRegistrada;
    private String statusTermico;
    private LocalDateTime dataHoraLeitura;

    public LeituraTermica() {}

    public LeituraTermica(int idLeitura, Equipamento equipamento, double temperaturaRegistrada, String statusTermico, LocalDateTime dataHoraLeitura) {
        this.idLeitura = idLeitura;
        this.equipamento = equipamento;
        this.temperaturaRegistrada = temperaturaRegistrada;
        this.statusTermico = statusTermico;
        this.dataHoraLeitura = dataHoraLeitura;
    }

    public int getIdLeitura() { return idLeitura; }
    public void setIdLeitura(int idLeitura) { this.idLeitura = idLeitura; }
    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }
    public double getTemperaturaRegistrada() { return temperaturaRegistrada; }
    public void setTemperaturaRegistrada(double temperaturaRegistrada) { this.temperaturaRegistrada = temperaturaRegistrada; }
    public String getStatusTermico() { return statusTermico; }
    public void setStatusTermico(String statusTermico) { this.statusTermico = statusTermico; }
    public LocalDateTime getDataHoraLeitura() { return dataHoraLeitura; }
    public void setDataHoraLeitura(LocalDateTime dataHoraLeitura) { this.dataHoraLeitura = dataHoraLeitura; }

    @Override
    public String toString() {
        return "Leitura #" + idLeitura + " | Temp: " + temperaturaRegistrada + "°C | Status: " + statusTermico + " | Data/Hora: " + dataHoraLeitura;
    }
}