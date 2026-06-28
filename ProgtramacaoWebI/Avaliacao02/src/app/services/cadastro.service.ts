import { Injectable } from '@angular/core';
import type { Cadastro } from '../models/cadastro.model';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {
  private readonly baseUrl = 'https://bu.furb.br/mcardoso/progWeb/apiRestAval.php/cadastro/';

  async obterCadastro(id: number): Promise<Cadastro> {
    const response = await fetch(`${this.baseUrl}${id}`);
    if (!response.ok) {
      throw new Error(`Falha ao consultar cadastro: ${response.status}`);
    }
    return response.json();
  }

  async excluirCadastro(id: number): Promise<{ status: string; mensagem: string }> {
    const response = await fetch(`${this.baseUrl}${id}`, { method: 'DELETE' });
    if (!response.ok) {
      throw new Error(`Falha ao excluir cadastro: ${response.status}`);
    }
    return response.json();
  }

  async alterarCadastro(cadastro: Cadastro): Promise<{ status: string; mensagem: string }> {
    const response = await fetch(`${this.baseUrl}${cadastro.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(cadastro)
    });
    if (!response.ok) {
      throw new Error(`Falha ao alterar cadastro: ${response.status}`);
    }
    return response.json();
  }
}
