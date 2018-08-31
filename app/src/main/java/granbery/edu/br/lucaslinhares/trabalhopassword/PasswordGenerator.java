package granbery.edu.br.lucaslinhares.trabalhopassword;

import java.util.Random;

public class PasswordGenerator {
    private final Random random = new Random();
    private Boolean includeSymbols;
    private Boolean includeNumbers;
    private Boolean includeLowerCase;
    private Boolean includeUpperCase;
    private Integer size;

    public PasswordGenerator() {
        super();
    }

    public String generate() {
        char[] symbols = buildSymbolsTable();
        char[] password = new char[size];
        for (int i =0; i < size; i++) {
            password[i] = symbols[random.nextInt(symbols.length)];
        }
        return new String(password);
    }

    private char[] buildSymbolsTable() {
        StringBuilder tmp = new StringBuilder();
        if (includeNumbers) {
            for (char ch = '0'; ch <= '9'; ++ch) {
                tmp.append(ch);
            }
        }

        if (includeLowerCase) {
            for (char ch = 'a'; ch <= 'z'; ++ch){
                tmp.append(ch);
            }
        }

        if (includeUpperCase) {
            for (char ch = 'A'; ch <= 'Z'; ++ch){
                tmp.append(ch);
            }
        }

        if (includeSymbols) {
            tmp.append("@#$%-!?*^,:;~|&");
        }

        return tmp.toString().toCharArray();
    }

    public Boolean getIncludeSymbols() {
        return includeSymbols;
    }

    public void setIncludeSymbols(Boolean includeSymbols) {
        if (includeSymbols != null) {
            this.includeSymbols = includeSymbols;
        } else {
            throw new IllegalArgumentException("includeSymbols should be non null");
        }
    }

    public Boolean getIncludeNumbers() {
        return includeNumbers;
    }

    public void setIncludeNumbers(Boolean includeNumbers) {
        if (includeNumbers != null) {
            this.includeNumbers = includeNumbers;
        } else {
            throw new IllegalArgumentException("includeNumbers should be non null");
        }
    }

    public Boolean getIncludeLowerCase() {
        return includeLowerCase;
    }

    public void setIncludeLowerCase(Boolean includeLowerCase) {
        if (includeLowerCase != null) {
            this.includeLowerCase = includeLowerCase;
        } else {
            throw new IllegalArgumentException("includeLowerCase should be non null");
        }
    }

    public Boolean getIncludeUpperCase() {
        return includeUpperCase;
    }

    public void setIncludeUpperCase(Boolean includeUpperCase) {
        if (includeUpperCase != null) {
            this.includeUpperCase = includeUpperCase;
        } else {
            throw new IllegalArgumentException("includeUpperCase should be non null");
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if (size != null && size > 0) {
            this.size = size;
        } else {
            throw new IllegalArgumentException("size should be non null and greater than 0");
        }
    }

    @Override
    public String toString() {
        return "PasswordGenerator{" +
                "includeSymbols=" + includeSymbols +
                ", includeNumbers=" + includeNumbers +
                ", includeLowerCase=" + includeLowerCase +
                ", includeUpperCase=" + includeUpperCase +
                ", size=" + size +
                '}';
    }
}