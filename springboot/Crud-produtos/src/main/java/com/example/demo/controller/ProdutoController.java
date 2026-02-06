package com.example.demo.controller;

import com.example.demo.dto.ProdutoRequestDTO;
import com.example.demo.dto.ProdutoResponseDTO;
import com.example.demo.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // ===================== LISTAR =====================
    @Operation(
        summary = "Listar produtos",
        description = "Retorna todos os produtos cadastrados"
    )
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    // ===================== BUSCAR POR ID =====================
    @Operation(
        summary = "Buscar produto por ID",
        description = "Retorna um produto específico pelo ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    // ===================== CRIAR =====================
    @Operation(
        summary = "Criar produto",
        description = "Cadastra um novo produto"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(
            @RequestBody ProdutoRequestDTO dto
    ) {
        ProdutoResponseDTO response = produtoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ===================== ATUALIZAR =====================
    @Operation(
        summary = "Atualizar produto",
        description = "Atualiza os dados de um produto existente"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Produto atualizado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoRequestDTO dto
    ) {
        return ResponseEntity.ok(produtoService.atualizar(id, dto));
    }

    // ===================== DELETAR =====================
    @Operation(
        summary = "Excluir produto",
        description = "Remove um produto pelo ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Produto removido"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
    	produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
