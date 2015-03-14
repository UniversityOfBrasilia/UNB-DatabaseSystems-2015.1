package sequential;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerializeEmploy {

	public static Employ[] getEmployers(int amountOfEmployers) {

		Employ[] employersList = new Employ[amountOfEmployers];

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < employersList.length; i++) {

			Employ newEmploy = new Employ();

			System.out.println("Digite seu nome:");
			newEmploy.name = scanner.nextLine();
			System.out.println("Digite seu CPF:");
			newEmploy.cpf = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Digite seu Cargo:");
			newEmploy.job = scanner.nextLine();

			employersList[i] = newEmploy;
		}

		return employersList;

	}

	public static void writeEmployInFile(Employ[] employers) throws IOException {

		FileOutputStream employersFile = new FileOutputStream(
				"employersSequencialFile.txt");
		ObjectOutputStream employersStream = new ObjectOutputStream(
				employersFile);
		employersStream.writeObject(employers);

		employersStream.close();

		System.out.println("Lista salva com sucesso.");
	}

}
