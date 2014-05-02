package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <CuerpoWHEN> ::= �{� [<ListaSentencias>] [<Retorno>] �}� | �{� [<ListaSentencias>] [�<Exit>�] �}� 
* 
*/
public class CuerpoWhen {
	// Variable que almacema la paertura de llaves
	SimboloLexico aperturaLlaves;
	// Variable que almacema un Arraylist de sentencias
	ArrayList<Sentencia> sentencias;
	// Variable que almacema el token de retono o brack
	SimboloLexico salida;
	// Variable que almacema el cierre de llaves
	SimboloLexico cierreLlaves;
	
	/**
	 * Constructor, permite crear objetos de tipo CuerpoWhen
	 * @param aperturaLlaves
	 * @param sentencias
	 * @param salida
	 * @param cierreLlaves
	 */
	public CuerpoWhen(SimboloLexico aperturaLlaves, ArrayList<Sentencia> sentencias, SimboloLexico salida, SimboloLexico cierreLlaves){
		this.aperturaLlaves = aperturaLlaves;
		this.sentencias = sentencias;
		this.salida = salida;
		this.cierreLlaves = cierreLlaves;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoCiclo);

		if(aperturaLlaves != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(aperturaLlaves.getLexema()));
		}
		
		if(sentencias.size() > 0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaSentencias);
			for(Sentencia sentencia : sentencias){
				nodo.add(sentencia.getArbolVisual());
			}
			miRaiz.add(nodo);
		}
		
		if(salida != null){
			miRaiz.add(new DefaultMutableTreeNode(salida.getLexema() + Configuracion.dosPuntos + salida.getTipo()));
		}
		
		if(cierreLlaves != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreLlaves.getLexema()));
		}

		return miRaiz;
	}
}