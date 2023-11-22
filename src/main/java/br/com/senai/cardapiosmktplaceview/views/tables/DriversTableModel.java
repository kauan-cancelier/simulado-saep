package br.com.senai.cardapiosmktplaceview.views.tables;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import br.com.senai.cardapiosmktplaceview.model.Driver;

public class DriversTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private final int COLUMN_QTDE = 4;

	private List<Driver> driver;

	public DriversTableModel(List<Driver> driver) {
		this.driver = driver;
	}

	@Override
	public int getColumnCount() {
		return COLUMN_QTDE;
	}

	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Nome do motorista";
		} else if (column == 2) {
			return "CNH";
		} else if (column == 3) {
			return "Ações";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return driver.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return driver.get(rowIndex).getName();
		} else if (columnIndex == 2) {
			return driver.get(rowIndex).getCnh();
		} else if (columnIndex == 3) {
			return driver.get(rowIndex);
		}
		throw new IllegalArgumentException("Índice inválido");
	}

	@Override
	public int getRowCount() {
		return driver.size();
	}

	public Driver getPor(int rowIndex) {
		return driver.get(rowIndex);
	}

	public void removerPor(int rowIndex) {
		this.driver.remove(rowIndex);
	}
}