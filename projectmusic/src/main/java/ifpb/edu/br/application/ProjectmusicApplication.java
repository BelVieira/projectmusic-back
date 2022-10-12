package ifpb.edu.br.application;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.application.controller.AlbumController;
import ifpb.edu.br.application.controller.MusicController;
import ifpb.edu.br.application.model.Album;
import ifpb.edu.br.application.model.Music;

//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ProjectmusicApplication implements CommandLineRunner {

	@Autowired
	private MusicController musicController;

	@Autowired
	private AlbumController albumController;

//	@Autowired
//	private Album album;

	public ProjectmusicApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);
		Scanner leitor2 = new Scanner(System.in);

		System.out.print("  Menu " + "\n 1 - Criar e salvar um album " + "\n 2 - Listar albuns salvos "
				+ "\n 3 - Criar e salvar uma música " + "\n 4 - Listar músicas salvas " + "\n Digite aqui:  ");
		int opcao = Integer.parseInt(leitor.nextLine());

		/***************** Albuns ********************/
		if (opcao == 2) {
			List<Album> albuns = albumController.list();
			for (Album album : albuns) {
				System.out.println(album);
			}
		}

		if (opcao == 1) {
			System.out.println("1 - Insira os dados do Album: ");
			System.out.println("2 - Encerrar!!");
			opcao = Integer.parseInt(leitor2.nextLine());

			boolean entrar1 = true;
			if (opcao == 2) {
				entrar1 = false;
			}
			while (entrar1) {
				System.out.println("Título do Album: ");
				String a1 = leitor.nextLine();

				System.out.println("Ano de produção ");
				String a2 = leitor.next();

				albumController.create(a1, a2);

				System.out.println("Para encerrar, digite 3 ");
				int num = leitor2.nextInt();
				if (num == 3)
					System.out.println("Obrigada!");
				entrar1 = false;
			}
		}

		/***************** Músicas ********************/
		if (opcao == 3) {
			System.out.println("1 - Insira os dados da musica: ");
			System.out.println("2 - Encerrar!!");
			opcao = Integer.parseInt(leitor2.nextLine());

			boolean entrar2 = true;
			if (opcao == 2) {
				entrar2 = false;
			}
			while (entrar2) {
				System.out.println("Nome musica: ");
				String n1 = leitor.nextLine();

				System.out.println("Nome artista: ");
				String n2 = leitor.nextLine();

				System.out.println("Duração musica: ");
				float d = Float.parseFloat(leitor.nextLine());

				System.out.println("Escolha o album para adicionar musicas: \n" + albumController.list());
				int num2 = leitor2.nextInt();
				Album album = albumController.find(num2);

				System.out.println("Cheguei até aqui");
				musicController.create(n1, n2, d, album);

				System.out.println("Para encerrar, aperte 3 ");
				int num = leitor2.nextInt();
				if (num == 3)
					System.out.println("Obrigada!");
				entrar2 = false;
			}
		}
		if (opcao == 4) {
			List<Music> musics = musicController.list();
			for (Music music : musics) {
				System.out.println(music);
			}
		}
		leitor.close();
		leitor2.close();
	}
}