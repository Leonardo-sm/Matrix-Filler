package br.com.michelutti.matrices.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import br.com.michelutti.matrices.model.Matrix;
import br.com.michelutti.matrices.model.Piece;
import br.com.michelutti.matrices.model.SolvedMatrix;
import br.com.michelutti.matrices.control.AffirmationsController;
import br.com.michelutti.matrices.control.MatrixController;
import br.com.michelutti.matrices.control.PieceController;

import javax.swing.SwingConstants;

public class MainScreen {

	private JFrame frmTeste;
	private JTextField txtMatrixSize;
	
	private static Matrix matrixModel;
	private static MatrixController matrixController;
	private static SolvedMatrix solvedMatrix;
	private static PieceController pieceController;
	private static AffirmationsController affirmationsController;
	
	private Integer numLblQuantPiece = 0;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private int[] size;
	private int[][] matrix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmTeste.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeste = new JFrame();
		frmTeste.setTitle("Matrices");
		frmTeste.setBounds(100, 100, 300, 315);
		frmTeste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeste.getContentPane().setLayout(null);
		
		JLabel lblMatrixSize = new JLabel("Tamanho da Matriz");
		lblMatrixSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatrixSize.setBounds(65, 11, 144, 34);
		frmTeste.getContentPane().add(lblMatrixSize);
		
		txtMatrixSize = new JTextField();
		txtMatrixSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatrixSize.setBounds(65, 57, 144, 34);
		frmTeste.getContentPane().add(txtMatrixSize);
		txtMatrixSize.setColumns(10);
		
		matrixController = new MatrixController();
		pieceController = new PieceController();
		
		JButton btnNewButton = new JButton("Criar Pe\u00E7as");
		btnNewButton.setBounds(78, 182, 112, 23);
		frmTeste.getContentPane().add(btnNewButton);
		
		JLabel lblQuantidadeDePecas = new JLabel("Quantidade de Pe\u00E7as");
		lblQuantidadeDePecas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePecas.setBounds(65, 102, 159, 34);
		frmTeste.getContentPane().add(lblQuantidadeDePecas);
		
		JLabel lblQuantPecas = new JLabel(numLblQuantPiece.toString());
		lblQuantPecas.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantPecas.setFont(lblQuantPecas.getFont().deriveFont(lblQuantPecas.getFont().getSize() + 5f));
		lblQuantPecas.setBounds(117, 137, 36, 34);
		frmTeste.getContentPane().add(lblQuantPecas);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int[] pieceSize = matrixController.spliter(JOptionPane.showInputDialog("Insira o tamanho da peça:"));
					
					int id = pieceController.idGenerator(pieces, pieceSize[0], pieceSize[1]);

					Piece piece = new Piece(pieceSize[0], pieceSize[1], id);
					pieces.add(piece);
					numLblQuantPiece++;
					lblQuantPecas.setText(numLblQuantPiece.toString());
					lblQuantPecas.repaint();
					
				} catch(Exception ep) {
					JOptionPane.showMessageDialog(null, "Insira o tamanho da Peça corretamente lina x coluna ex: 2x2");
				}
			}
		});
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					size = matrixController.spliter(txtMatrixSize.getText());
					matrixModel = new Matrix(size[0], size[1]);
					matrix = matrixModel.getMatrix();
					
					matrixModel = new Matrix(size[0], size[1]);
					matrix = matrixModel.getMatrix();
					
					solvedMatrix = new SolvedMatrix(pieces, matrix, size[0], size[1]);
					affirmationsController = new AffirmationsController(solvedMatrix.getMatrix(), size[0], size[1]);
					String print = matrixController.printMatrix(solvedMatrix.getMatrix(), affirmationsController.getAffirmations());

					JOptionPane.showMessageDialog(null, print);
					
				} catch(StackOverflowError sof) {
					JOptionPane.showMessageDialog(null, "As peças não cabem na matriz, por favor insira novamente as peças e seus tamanhos");
					pieces = new ArrayList<Piece>();
					numLblQuantPiece = 0;
					lblQuantPecas.setText(numLblQuantPiece.toString());
					lblQuantPecas.repaint();
					
					matrixModel = new Matrix(size[0], size[1]);
					matrix = matrixModel.getMatrix();
					pieceController.setId(1);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Insira o tamanho da Peça corretamente lina x coluna ex: 2x2");
				}
			}
		});
		btnGerar.setBounds(78, 231, 112, 23);
		frmTeste.getContentPane().add(btnGerar);
	}
}
