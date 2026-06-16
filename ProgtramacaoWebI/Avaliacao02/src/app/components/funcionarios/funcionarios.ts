import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Funcionario } from '../../models/funcionario.model';
import { FuncionarioService } from '../../services/funcionario.service';

@Component({
  selector: 'app-funcionarios',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './funcionarios.html',
  styleUrl: './funcionarios.css',
})
export class Funcionarios implements OnInit {
  funcionarios: Funcionario[] = [];

  constructor(private service: FuncionarioService) {}

  ngOnInit(): void {
    this.funcionarios = this.service.obterFuncionarios();
  }
}
