package com.birouska.encontreme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.birouska.encontreme.model.Estado;
import com.birouska.encontreme.utility.*;

import java.sql.Connection;

public class EstadoDAO {

	public List<Estado> List() {

		String sql = "SELECT * FROM tb_estado";

		List<Estado> estados = new ArrayList<Estado>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.getConnection();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Estado estado = new Estado();

				// Recupera o id do banco e atribui ele ao objeto
				estado.setUF(rset.getString("uf"));

				// Recupera o nome do banco e atribui ele ao objeto
				estado.setNome(rset.getString("nome"));

				// Adiciono o contato recuperado, a lista de contatos
				estados.add(estado);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return estados;
	}

}
