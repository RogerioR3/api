import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private Date dataNascimento;
    
    
    public ClientePessoaFisica(int idCliente, String nome, String email, String endereco, String telefone, String userName, String password, String cpf, String rg, Date dataNascimento) {
        super(idCliente, nome, email, endereco, telefone, userName, password);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        
    }
    
    public ClientePessoaFisica(int idCliente) {
        super(idCliente);
        int m = 0;
        String cpf, rg;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        while(m < 3){
            switch (m) {
                case 0:
                    System.out.print("  -> CPF = ");
                    cpf = sc.nextLine();
                    if(isValidCPF(cpf)){
                        this.cpf = cpf;
                        m++;
                    }else {System.out.println("CPF inválido!");}
                    break;
                case 1:
                    System.out.print("  -> RG = ");
                    rg = sc.nextLine();
                    if(isValidRG(rg)){
                        this.rg = rg;
                        m++;
                    }else {System.out.println("RG inválido!");}
                    break;
                case 2:
                    System.out.print("  -> Data de Nascimento (dia/mes/ano) = ");
                    String dataString = sc.nextLine();
                    try {
                        // Converte a string para um objeto Date
                        this.dataNascimento = sdf.parse(dataString);
                    } catch (ParseException e) {
                        System.out.println("Data inválida. Certifique-se de usar o formato dd/MM/yyyy.");
                    }
                    m++;
                    break;
            }
        }
    }
    
    public boolean validarCPF(String cpf) {
        //return this.cpf.equals(cpf);
        if (this.cpf == cpf) return true;
        return false;
    }
    
    @Override
    public void atualizaDados(Cliente cliente) {
        if (cliente instanceof ClientePessoaFisica) {
            ClientePessoaFisica pf = (ClientePessoaFisica) cliente;
            this.setNome(pf.getNome());
            this.setEmail(pf.getEmail());
            this.setEndereco(pf.getEndereco());
            this.setTelefone(pf.getTelefone());
            this.setUserName(pf.getUserName());
            this.setPassword(pf.getPassword());
            this.setCpf(pf.getCpf());
            this.setRg(pf.getRg());
            this.setDataNascimento(pf.getDataNascimento());
        }
    }
    
    // Getters and Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    //Verifica CPF 
    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verificar se todos os dígitos são iguais
        char firstDigit = cpf.charAt(0);
        if (cpf.chars().allMatch(c -> c == firstDigit)) {
            return false;
        }
        
        try {
            int[] digits = cpf.chars().map(c -> c - '0').toArray();
            return verifyDigit(digits, 9) && verifyDigit(digits, 10);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean verifyDigit(int[] digits, int length) {
        int sum = 0;
        int weight = length + 1;
        
        for (int i = 0; i < length; i++) {
            sum += digits[i] * weight--;
        }
        
        int remainder = sum % 11;
        int checkDigit = (remainder < 2) ? 0 : 11 - remainder;
        return checkDigit == digits[length];
    }
    //isValidCPF(cpf)
    
    //Verifica CPF 
    public static boolean isValidRG(String rg) {
        rg = rg.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        
        // Defina o comprimento esperado do RG. Exemplo: 9 dígitos.
        int expectedLength = 9;
        if (rg.length() != expectedLength) {
            return false;
        }
        
        // Adicione qualquer outra verificação específica de formato ou dígito verificador aqui, se necessário
        return true; // Se passou nas verificações básicas
    }//isValidRG(rg)
}
