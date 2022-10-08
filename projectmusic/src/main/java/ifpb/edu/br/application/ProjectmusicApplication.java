package ifpb.edu.br.application;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.application.controller.MusicController;
import ifpb.edu.br.application.model.Music;

//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ProjectmusicApplication implements CommandLineRunner {

	@Autowired
	private MusicController musicController;

//	@Autowired
//	private AlbumController albumController;

	public ProjectmusicApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);
		Scanner leitor2 = new Scanner(System.in);

		System.out.print("  Menu " + "\n 1 - Criar e salvar uma música " + "\n 2 - Listar músicas salvas "
				+ "\n Digite aqui:  ");
		int opcao = Integer.parseInt(leitor.nextLine());

		if (opcao == 1) {
			System.out.println("1 - Insira os dados da musica: ");
			System.out.println("2 - Encerrar!!");
			opcao = Integer.parseInt(leitor2.nextLine());

			boolean entrar = true;
			if (opcao == 2) {
				entrar = false;
			}
			while (entrar) {
				System.out.println("Nome musica: ");
				String n1 = leitor.nextLine();

				System.out.println("Nome artista: ");
				String n2 = leitor.next();

				System.out.println("Duração musica: ");
				float d = leitor.nextFloat();

				musicController.create(n1, n2, d);

				System.out.println("Para encerrar, aperte 3 ");
				int num = leitor2.nextInt();
				if (num == 3)
					System.out.println("Obrigada!");
				entrar = false;
			}
		}
		if (opcao == 2) {
			List<Music> musics = musicController.list();
			for (Music music : musics) {
				System.out.println(music);
			}
		}
		leitor.close();
	}
}