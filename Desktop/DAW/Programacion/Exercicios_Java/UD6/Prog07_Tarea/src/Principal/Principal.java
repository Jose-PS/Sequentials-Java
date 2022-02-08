
package Principal;

import Banco.Banco;
import Banco.ContaAforro;
import Banco.ContaBancaria;
import Banco.ContaEmpresa;
import Banco.ContaPersoal;
import Persoa.Persoa;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Principal {

    private Banco banco = new Banco();
    private String tipoConta;
    Scanner lec = new Scanner(System.in);

    void run() {
        char opt;
        String iban;
        String lista[];
        double cant;
        Menu m = new Menu("Banco do Hio, escolle unha opcion.", new String[]{"(A)brir nova conta.", "(V)er listado de contas.", "(O)bter datos dunha conta.", "(I)ngresar efectivo en conta.", "(R)etirar efectivo de conta.", "(C)onsultar saldo en conta.", "(S)air."}, "avoircs");
        do {
            opt = m.getOpcion();
            switch (opt) {
                case 'a':
                    abreConta();
                    break;
                case 'v':
                    lista = banco.listadoContas();
                    for (int i = 0; i < lista.length; i++) {
                        System.out.println(lista[i]);
                    }
                    break;
                case 'o':
                    System.out.println("Introduce o IBAN: ");
                    banco.informacionConta(lec.nextLine());
                    break;
                case 'i':
                    System.out.println("Introduce o IBAN: ");
                    iban = lec.nextLine();
                    System.out.println("Introduce a cantidade: ");
                    cant = Double.parseDouble(lec.nextLine());
                    banco.ingresoConta(iban, cant);
                    break;
                case 'r':
                    break;
                case 'c':
                    break;
                case 's':
                    break;
            }
        } while (opt != 's');
    }

    private Persoa novaPersoa() {
        String dni;
        String nome;
        String apelidos;
        Persoa p = null;
        System.out.println("Introduce os datos do cliente.");
        System.out.println("Nome.");
        nome = lec.nextLine();
        System.out.println("Apelidos.");
        apelidos = lec.nextLine();
        System.out.println("DNI.");
        dni = lec.nextLine();
        p = new Persoa(nome, apelidos, dni);
        return p;
    }

    private void abreConta() {
        ContaBancaria conta = null;
        Persoa p = null;
        int[] opts;
        Object[] datos = new Object[7];
        boolean abrirConta;
        String[] opcions = new String[]{"Saldo.", "Numero de conta.", "Tipo de interes.", "Comision de mantemento.", "Maximo descuberto permitido.", "Tipo de interes por descuberto.", "Comision fija por descuberto."};
        p = novaPersoa();
        do {
            opts = getTipo();
            System.out.println("Introduce os datos da conta.");
            for (int i = 0; i < opts.length; i++) {
                System.out.println(opcions[opts[i]]);
                datos[opts[i]] = lec.nextLine();
            }
            if (tipoConta.charAt(0) == 'e') {
                conta = new ContaEmpresa(p, (Double.parseDouble(datos[opts[0]].toString())), ((String) datos[opts[1]]), (Double.parseDouble(datos[opts[2]].toString())), (Double.parseDouble(datos[opts[3]].toString())), (Double.parseDouble(datos[opts[4]].toString())), ContaBancaria.TipoConta.EMPRESA);
            } else if (tipoConta.charAt(0) == 'p') {
                conta = new ContaPersoal(p, (Double.parseDouble(datos[opts[0]].toString())), ((String) datos[opts[1]]), (Double.parseDouble(datos[opts[2]].toString())), ContaBancaria.TipoConta.PERSOAL);
            } else if (tipoConta.charAt(0) == 'a') {
                conta = new ContaAforro(p, (Double.parseDouble(datos[opts[0]].toString())), ((String) datos[opts[1]]), (Double.parseDouble(datos[opts[2]].toString())), ContaBancaria.TipoConta.AFORRO);
            }
            abrirConta = banco.abrirConta(conta);
        } while (!abrirConta);
    }

    public int[] getTipo() {
        char escolle;
        int[] opts = null;
        Menu m = new Menu ("Que tipo de conta desexas crear?",new String [] {"Conta de (E)mpresa", "Conta (P)ersoal", "Conta de (A)forro"}, "epa", Menu.Direccion.HORIZONTAL );
        escolle = m.getOpcion();
        if (escolle == 'e') {
            tipoConta = "empresa";
            opts = new int[]{0, 1, 4, 5, 6
            };
        } else if (escolle == 'p') {
            tipoConta = "persoal";
            opts = new int[]{0, 1, 3};
        } else if (escolle == 'a') {
            tipoConta = "aforro";
            opts = new int[]{0, 1, 2};
        }
        return opts;
    }

    public static void main(String[] args) {
        Principal main = new Principal();
        main.run();
    }

}
