package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]{2,} [A-Za-zÀ-ÖØ-öø-ÿ]{2,}(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
            message = "Erro minimo aceito são duas palavras ")
    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    @Null
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]{2,} [A-Za-zÀ-ÖØ-öø-ÿ]{2,}(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
            message = "Erro minimo aceito são duas palavras ")
    private String especialidade;

}
