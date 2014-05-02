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
* <DeclaracionMetodo> ::= <ModificadorAcceso> <TipoDato> <IdMetodo> �(� [<Argumentos>] �)�  <CuerpoMetodo> 
*/
public class DeclaracionMetodo {
	
	SimboloLexico modificadorAcceso;
	SimboloLexico tipoDato;
	SimboloLexico idMetodo;
	SimboloLexico aperturaParentesis;
	ArrayList<Argumento> argumentos;
	SimboloLexico cierreParentesis;
	CuerpoMetodo cuerpoMetodo;
	
	public DeclaracionMetodo(SimboloLexico modificadorAcceso, SimboloLexico tipoDato, SimboloLexico idMetodo, SimboloLexico aperturaParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis, CuerpoMetodo cuerpoMetodo){
		this.modificadorAcceso = modificadorAcceso;
		this.tipoDato = tipoDato;
		this.idMetodo = idMetodo;
		this.aperturaParentesis = aperturaParentesis;
		this.argumentos = argumentos;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoMetodo = cuerpoMetodo;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.declaracionMetodo);

		if(modificadorAcceso != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso.getLexema() + Configuracion.dosPuntos + modificadorAcceso.getTipo()));
		}
		
		if(tipoDato != null){
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema() + Configuracion.dosPuntos + tipoDato.getTipo()));
		}
		
		if(idMetodo != null){
			miRaiz.add(new DefaultMutableTreeNode(idMetodo.getLexema() + Configuracion.dosPuntos + idMetodo.getTipo()));
		}
		
		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(argumentos !=null || argumentos.size() > 0)
		{		
			DefaultMutableTreeNode aNode = new DefaultMutableTreeNode(Configuracion.argumentos);

			for (Argumento argumento : argumentos) 
			{
				aNode.add(argumento.getArbolVisual());
			}

			miRaiz.add(aNode);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}
		
		if(cuerpoMetodo != null){
			miRaiz.add(cuerpoMetodo.getArbolVisual());
		}

		return miRaiz;
	}
}
