package br.com.oticanewlook.oticanewlook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.oticanewlook.oticanewlook.model.FuncionarioModel;


public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    
    @Query(value = "SELECT * FROM funcionario WHERE email =:email and senha =:senha", nativeQuery = true)
    public FuncionarioModel Login(@Param("email") String email, @Param("senha") String senha);

    @Query(value = "SELECT * FROM funcionario WHERE ativo = 'S'", nativeQuery = true)
    public List<FuncionarioModel> findlAllAtivo();

    @Modifying@Query(value = "UPDATE funcionario SET ativo = 'N' WHERE id_func =:id_func", nativeQuery = true)
    void inativar(@Param("id_func") FuncionarioModel funcionarioModel);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
    
    boolean existsById(int id_func);
    
    
}
