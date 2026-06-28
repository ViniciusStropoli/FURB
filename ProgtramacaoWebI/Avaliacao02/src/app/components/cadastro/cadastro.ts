import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CadastroService } from '../../services/cadastro.service';
import type { Cadastro as CadastroData } from '../../models/cadastro.model';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cadastro.html',
  styleUrl: './cadastro.css',
})
export class CadastroComponent {
  searchId = signal<number | null>(null);
  cadastro = signal<CadastroData | null>(null);
  feedback = signal<{ status: string; mensagem: string } | null>(null);
  carregando = signal(false);
  error = signal('');

  nome = signal('');
  departamento = signal('');
  endereco = signal('');
  email = signal('');

  constructor(private service: CadastroService) {}

  async consultar(): Promise<void> {
    this.clearFeedback();
    this.error.set('');
    const id = this.searchId();

    if (!id || id <= 0) {
      this.error.set('Informe um ID válido para consulta.');
      return;
    }

    this.carregando.set(true);
    try {
      const cadastro = await this.service.obterCadastro(id);
      this.cadastro.set(cadastro);
      this.nome.set(cadastro.nome);
      this.departamento.set(cadastro.departamento);
      this.endereco.set(cadastro.endereco);
      this.email.set(cadastro.email);
    } catch (err) {
      this.cadastro.set(null);
      this.error.set(err instanceof Error ? err.message : 'Erro na consulta.');
    } finally {
      this.carregando.set(false);
    }
  }

  async exclusao(): Promise<void> {
    this.clearFeedback();
    const cadastro = this.cadastro();
    if (!cadastro) {
      this.error.set('Consulte um cadastro antes de excluir.');
      return;
    }

    this.carregando.set(true);
    try {
      const response = await this.service.excluirCadastro(cadastro.id);
      this.feedback.set(response);
      if (response.status === 'Ok') {
        this.cadastro.set(null);
      }
    } catch (err) {
      this.error.set(err instanceof Error ? err.message : 'Erro ao excluir cadastro.');
    } finally {
      this.carregando.set(false);
    }
  }

  async alterar(): Promise<void> {
    this.clearFeedback();
    const cadastro = this.cadastro();
    if (!cadastro) {
      this.error.set('Consulte um cadastro antes de alterar.');
      return;
    }

    const payload: CadastroData = {
      id: cadastro.id,
      nome: this.nome(),
      departamento: this.departamento(),
      endereco: this.endereco(),
      email: this.email(),
    };

    this.carregando.set(true);
    try {
      const response = await this.service.alterarCadastro(payload);
      this.feedback.set(response);
      if (response.status === 'Ok') {
        this.cadastro.set(payload);
      }
    } catch (err) {
      this.error.set(err instanceof Error ? err.message : 'Erro ao alterar cadastro.');
    } finally {
      this.carregando.set(false);
    }
  }

  private clearFeedback(): void {
    this.feedback.set(null);
    this.error.set('');
  }
}
