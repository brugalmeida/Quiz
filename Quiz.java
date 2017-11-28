package quiz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener {
	//menu
	public static final int USER = 1;
	public static final int JOGAR = 2;
	public static final int SAIR = 3;
	//perguntas
	static String [][] perguntas = new String [5][7];
	JRadioButton [] alternativas = new JRadioButton[5]; //alternativas onde só uma pode ser selecionada
	JLabel pergunta = new JLabel(""); //texto da pergunta
	JLabel pontuacao = new JLabel(" Pontuação: 0  "); //texto pontuação
	int totalPontos = 0; //somatório dos pontos
	int pontos = 0; //somar os pontos
	JButton responder = new JButton("Responder");//botão para responder e passar para próxima pergunta
	ButtonGroup orgBotoes = new ButtonGroup();//organizar os JRadioButtons 
	//cadastro de usuário
	static String user;
		
	public Quiz() {
		setLayout (new GridLayout(9,4));
		perguntas();
	for (int i=0; i<5; i++){
		alternativas[i] = new JRadioButton();
		orgBotoes.add(alternativas[i]);	
			}
	
	    telaJogo();
		pontuacao.setHorizontalAlignment(JTextField.RIGHT);
		add(pergunta);
		add(alternativas[0]);
		add(alternativas[1]);
		add(alternativas[2]);
		add(alternativas[3]);
		add(alternativas[4]);
		add(pontuacao);
		add(responder);
		
		responder.addActionListener(null);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}	
	
		public static void main ( String []args ){
		  do{
			  int opcao = menu();
			  executarMenu (opcao);
			  	  } while(true);
	  }

	public static int menu() {
	System.out.println("MENU");
	System.out.println("Digite 1 para Cadastrar Usuário");
	System.out.println("Digite 2 para Jogar");
	System.out.println("Digite 3 para Sair");

	System.out.println("\n");
	System.out.println("Digite uma opção:");
	
	Scanner s = new Scanner (System.in);
	int opcao = s.nextInt();
	
	return opcao;
	}

	public static void executarMenu (int opcao) {
		switch (opcao){
		case USER:  cadUser(); break;
		case JOGAR: Jogar(); break;
		case SAIR: System.exit(SAIR);
		default: System.out.println("Digite uma opção:");
			
		}
		
	}
			private static void cadUser() {
				
				user = JOptionPane.showInputDialog("Digite seu nome: ",JOptionPane.INFORMATION_MESSAGE); 
			    JOptionPane.showMessageDialog(null,"Bem vindo(a) ao Quiz, " + user + "!"); 
			}

			private static void Jogar() {
		new Quiz();
	}

			public static void perguntas(){
			perguntas [0][0] = "A Princesa Isabel foi responsável por um grande feito na história do Brasil. Qual foi este feito?";
			perguntas [0][1] = "A libertação dos escravos";
			perguntas [0][2] = "A Proclamação da República";
			perguntas [0][3] = "A libertação dos índios";
			perguntas [0][4] = "A instituição do Português como língua oficial";
			perguntas [0][5] = "A anistia política no país";
			perguntas [0][6] = "1";
			
			perguntas [1][0] = "A montanha mais alta do mundo chama-se:";
			perguntas [1][1] = "Dedo de Deus";
			perguntas [1][2] = "Tibete";
			perguntas [1][3] = "Aconcágua";
			perguntas [1][4] = "Monte Everest";
			perguntas [1][5] = "Monte Sinai";
			perguntas [1][6] = "4";
			
			perguntas [2][0] = "Planeta do Sistema Solar que possui anéis de poeira mais visíveis à sua volta";
			perguntas [2][1] = "Mercúrio";
			perguntas [2][2] = "Júpiter";
			perguntas [2][3] = "Plutão";
			perguntas [2][4] = "Saturno";
			perguntas [2][5] = "Marte";
			perguntas [2][6] = "4";
			
			perguntas [3][0] = "Quem proclamou a república no Brasil foi:";
			perguntas [3][1] = "Pero Vaz de Caminha";
			perguntas [3][2] = "Marechal Deodoro da Fonseca";
			perguntas [3][3] = "General Pedro I";
			perguntas [3][4] = "Floriano Peixoto";
			perguntas [3][5] = "Dom João VI";
			perguntas [3][6] = "2";
			
			perguntas [4][0] = "O maior e mais famoso navio do mundo, que afundou em sua primeira viagem foi";
			perguntas [4][1] = "O Queen Elisabeth";
			perguntas [4][2] = "The Big Ship";
			perguntas [4][3] = "Eugênio C";
			perguntas [4][4] = "O Barco Mississipi";
			perguntas [4][5] = "O Titanic";
			perguntas [4][6] = "5";
		}
	
			private void telaJogo() {
			
			for(int i=0; i<5; i++){
			pergunta.setText(perguntas[totalPontos][0]);
			}
				for(int i=0; i<5; i++){
					alternativas[i].setText(perguntas[totalPontos][i+1]);
				}
							
			}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		int respostaCorreta = Integer.parseInt(perguntas[totalPontos][6]);
	
		if(alternativas[respostaCorreta-1].isSelected()){
			pontos++;
				
		pontuacao.setText("Pontuação: " + pontos);
		}
		
		else{
			JOptionPane.showMessageDialog(null,"Game Over!");
			menu();
		}
		
		
		}
		
		
	}
	

	
