export interface SubObjeto {
  propriedadel: string;
  propriedade2: string; 
}

export interface Funcionario {
  id: number; 
  nome: string; 
  foto: string; 
  email: string;
  subobjeto: SubObjeto;
}