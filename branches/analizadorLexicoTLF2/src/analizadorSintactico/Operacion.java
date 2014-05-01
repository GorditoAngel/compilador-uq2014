package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <Operacion> ::= <OperadorMatematico> <IdVariable> | <OperadorMatematico> <valor> | <OperadorMatematico> <IdVariable> <Operacion> | <OperadorMatematico> <valor> <Operacion>

*/
public class Operacion {

	SimboloLexico operadorMatematico = null;
	SimboloLexico idVariable = null;


	public Operacion(SimboloLexico operadorMatematico, SimboloLexico idVariable){

		this.operadorMatematico = operadorMatematico;
		this.idVariable = idVariable;
	}



	public DefaultMutableTreeNode getArbolVisual(){

		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.operacion);

		if(operadorMatematico!=null){
			miRaiz.add(new DefaultMutableTreeNode(operadorMatematico.getTipo()+Configuracion.dosPuntos+ operadorMatematico.getLexema()));
		}
		if(idVariable!=null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+Configuracion.dosPuntos+ idVariable.getLexema()) );
		}

		return miRaiz;
	}
}