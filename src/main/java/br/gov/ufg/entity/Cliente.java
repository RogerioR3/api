import java.util.Scanner;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Cliente {
    protected Scanner sc = new Scanner(System.in);
    
    private int idCliente;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String userName;
    private String password;

    
    public Cliente(int idCliente, String nome, String email, String endereco, String telefone, String userName, String password) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.userName = userName;
        this.password = password;
    }
    
    public Cliente(int idCliente) {
        int m = 0;
        String senha = " ", confSenha = " ", email;
        System.out.println("Insira os dados:");
        
        while(m < 7){
            switch (m) {
                case 0:
                    System.out.print("  -> Nome = ");
                    this.nome = sc.nextLine();
                    m++;
                    break;
                case 1:
                    System.out.print("  -> Email = ");
                    email = sc.nextLine();
                    if(isValidEmail(email)){
                        this.email = email;
                        m++;
                    }else{
                        System.out.println("Email inválido!");
                    }
                    break;
                case 2:
                    System.out.print("  -> Endereço = ");
                    this.endereco = sc.nextLine();
                    m++;
                    break;
                case 3:
                    System.out.print("  -> Telefone = ");
                    this.telefone = sc.nextLine();
                    m++;
                    break;
                case 4:
                    System.out.print("  -> Nome de Usuário = ");
                    this.userName = sc.nextLine();
                    m++;
                    break;
                case 5:
                    System.out.print("  -> Senha = ");
                    senha = sc.nextLine();
                    m++;
                    break;
                case 6:
                    System.out.print("  -> Confirmar Senha = ");
                    confSenha = sc.nextLine();
                    if(Objects.equals(senha, confSenha)){
                        this.password = senha;
                        m++;
                    }else{
                        System.out.println("As duas senhas devem ser iguais!");
                        m--;
                    }
                    break;
            }
        }
    }

    public boolean login(String userName, String password){
        return this.userName.equals(userName) && this.password.equals(password);
    }
    
    public void atualizaDados(Cliente cliente){
        if (cliente != null) {
            this.nome = cliente.getNome();
            this.email = cliente.getEmail();
            this.endereco = cliente.getEndereco();
            this.telefone = cliente.getTelefone();
            this.userName = cliente.getUserName();
            this.password = cliente.getPassword();
        }
    }
    
    // Getters and Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Verificação de email
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //isValidEmail(email)
    
    

}


/*
Cadastrar Cliente - Cadastrar novo cliente no sistema; Atualizar os dados de um
cliente.
Realizar Pedido - Escolher itens para compra; Confirmar os itens do pedido; Listar
histórico de pedidos efetuados.
//*/
