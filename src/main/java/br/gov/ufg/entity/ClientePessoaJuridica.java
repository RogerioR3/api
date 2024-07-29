public class ClientePessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;
    
    
    public ClientePessoaJuridica(int idCliente, String nome, String email, String endereco, String telefone, String userName, String password, String cnpj, String razaoSocial, String inscricaoEstadual) {
        super(idCliente, nome, email, endereco, telefone, userName, password);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        
    }
    
    public ClientePessoaJuridica(int idCliente) {
        super(idCliente);
        String cnpj;
        int m = 0;
        
        while(m < 3){
            switch (m) {
                case 0:
                    System.out.print("  -> CNPJ = ");
                    cnpj = sc.nextLine();
                    if(isValidCNPJ(cnpj)){
                        this.cnpj = cnpj;
                        m++;
                    }else {System.out.println("RG inválido!");}
                    break;
                case 1:
                    System.out.print("  -> Razão Social = ");
                    this.razaoSocial = sc.nextLine();
                    m++;
                    break;
                case 2:
                    System.out.print("  -> Inscrição Estadual = ");
                    this.inscricaoEstadual = sc.nextLine();
                    m++;
                    break;
            }
        }
    }
    
    public boolean validarCNPJ(String cnpj) {
        //return this.cnpj.equals(cnpj);
        if (this.cnpj == cnpj) return true;
        return false;
    }
    
    @Override
    public void atualizaDados(Cliente cliente) {
        if (cliente instanceof ClientePessoaJuridica) {
            ClientePessoaJuridica pj = (ClientePessoaJuridica) cliente;
            this.setNome(pj.getNome());
            this.setEmail(pj.getEmail());
            this.setEndereco(pj.getEndereco());
            this.setTelefone(pj.getTelefone());
            this.setUserName(pj.getUserName());
            this.setPassword(pj.getPassword());
            this.setCnpj(pj.getCnpj());
            this.setRazaoSocial(pj.getRazaoSocial());
            this.setInscricaoEstadual(pj.getInscricaoEstadual());
        }
    }
    
    // Getters and Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    //Verifica CNPJ
    public static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        if (cnpj.length() != 14) {return false;}
        
        // Verificar se todos os dígitos são iguais
        char firstDigit = cnpj.charAt(0);
        if (cnpj.chars().allMatch(c -> c == firstDigit)) {return false;}
        
        try {
            int[] digits = cnpj.chars().map(c -> c - '0').toArray();
            return verifyDigit(digits, 12) && verifyDigit(digits, 13);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean verifyDigit(int[] digits, int length) {
        int[] weights = (length == 12)
            ? new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2} // Pesos para o primeiro dígito verificador
            : new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; // Pesos para o segundo dígito verificador
            
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += digits[i] * weights[i];
        }
        
        int remainder = sum % 11;
        int checkDigit = (remainder < 2) ? 0 : 11 - remainder;
        return checkDigit == digits[length];
    }
    //isValidCNPJ(cnpj)
}
