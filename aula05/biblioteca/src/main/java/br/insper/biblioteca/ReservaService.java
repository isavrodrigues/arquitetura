package br.insper.biblioteca;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservaService {

    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void cadastrarReserva(String codigo, LocalDateTime dataHora, Usuario usuario, Livro livro) {
        Reserva reserva = new Reserva();
        reserva.setCodigo(codigo);
        reserva.setLocalDateTime(dataHora);
        reserva.setUsuario(usuario);
        reserva.setLivro(livro);

        reservas.add(reserva);
        livro.adicionaReserva(reserva);
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Código: " + reserva.getCodigo());
            System.out.println("Data/Hora: " + reserva.getLocalDateTime());
            System.out.println("Usuário: " + reserva.getUsuario().getNome());
            System.out.println("Livro: " + reserva.getLivro().getNome());
        }
    }
}