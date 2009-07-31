/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PFinanceMain.java
 *
 * Created on 07/07/2009, 00:29:45
 */
package pfinance.view;

import javax.swing.UIManager;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorCaixa;
import pfinance.controller.GerenciadorDocumento;
import pfinance.controller.GerenciadorObjetos;
import pfinance.controller.GerenciadorSessao;
import pfinance.model.entity.MesRef;
import pfinance.model.entity.Usuario;
import pfinance.view.dataset.ArvoreObjetos;
import pfinance.view.dataset.BarraStatus;
import pfinance.view.dataset.Principal;
import pfinance.view.dataset.TabelaCaixa;
import pfinance.view.dataset.TabelaMesRef;

/**
 *
 * @author higorlandia
 */
public class PFinanceMain extends javax.swing.JFrame {

    private GerenciadorSessao gerSessao;
    private GerenciadorDocumento gerDocumento;
    private GerenciadorCaixa gerCaixa;
    private GerenciadorObjetos gerObjetos;

    /** Creates new form PFinanceMain */
    public PFinanceMain() {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows
//"com.sun.java.swing.plaf.gtk.GTKLookAndFeel"
//"javax.swing.plaf.metal.MetalLookAndFeel"
//"com.sun.java.swing.plaf.windows.WindowsLookAndFeel""
//"com.sun.java.swing.plaf.motif.MotifLookAndFeel"
//"javax.swing.plaf.mac.MacLookAndFeel - Mac"
        } catch (Exception e) {
            //Inseira qualuquer codigo, se necessário.
        }
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        internalCentralFrame = new javax.swing.JInternalFrame();
        splitCentral = new javax.swing.JSplitPane();
        splitEsquerdo = new javax.swing.JSplitPane();
        tabPaneItens = new javax.swing.JTabbedPane();
        scrollItens = new javax.swing.JScrollPane();
        arvoreObjetos = new javax.swing.JTree();
        tabPaneMesRef = new javax.swing.JTabbedPane();
        scrollMesRef = new javax.swing.JScrollPane();
        tabelaMesRef = new javax.swing.JTable();
        tabPaneMovimentacao = new javax.swing.JTabbedPane();
        panelCustos = new javax.swing.JPanel();
        scrollTabelaCustos = new javax.swing.JScrollPane();
        tabelaCustos = new javax.swing.JTable();
        panelResumo = new javax.swing.JPanel();
        panelTotalMes = new javax.swing.JPanel();
        lbTotalPrevistoMes = new javax.swing.JLabel();
        txtTotalPrevistoMes = new javax.swing.JTextField();
        lbTotalRealizadoMes = new javax.swing.JLabel();
        txtTotalRealizadoMes = new javax.swing.JTextField();
        panelDebitoCredito = new javax.swing.JPanel();
        lbDebito = new javax.swing.JLabel();
        txtDebito = new javax.swing.JTextField();
        lbCredito = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        panelResumoSaldo = new javax.swing.JPanel();
        lbSaldoAnterior = new javax.swing.JLabel();
        txtSaldoAnterior = new javax.swing.JTextField();
        lbSaldoAtual = new javax.swing.JLabel();
        txtSaldoAtual = new javax.swing.JTextField();
        statusBar = new javax.swing.JPanel();
        statusPanelIdentificacao = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbUsuarioAtivo = new javax.swing.JLabel();
        statusPanelAvisos = new javax.swing.JPanel();
        lbAvisos = new javax.swing.JLabel();
        statusPanelMensagens = new javax.swing.JPanel();
        lbMensagens = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        tbNovo = new javax.swing.JButton();
        tbAbrir = new javax.swing.JButton();
        tbSalvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        tbUndo = new javax.swing.JButton();
        tbRedo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        tbConfigurar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        tbCategorias = new javax.swing.JButton();
        tbMes = new javax.swing.JButton();
        tbTipoConta = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        tbReceita = new javax.swing.JButton();
        tbCusto = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        mnNovoDocumento = new javax.swing.JMenuItem();
        mnAbrirDocumento = new javax.swing.JMenuItem();
        mnSalvar = new javax.swing.JMenuItem();
        mnSalvarComo = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        mnUsuarios = new javax.swing.JMenuItem();
        mnCategorias = new javax.swing.JMenuItem();
        mnMes = new javax.swing.JMenuItem();
        mnTipoConta = new javax.swing.JMenuItem();
        menuLancamentos = new javax.swing.JMenu();
        mnCustos = new javax.swing.JMenuItem();
        mnReceita = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        mnConteudo = new javax.swing.JMenuItem();
        mnSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PFinance - Personal Finance");
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        internalCentralFrame.setMaximizable(true);
        internalCentralFrame.setVisible(true);
        internalCentralFrame.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        splitEsquerdo.setDividerLocation(200);
        splitEsquerdo.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arvoreObjetos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvoreObjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arvoreObjetosMouseClicked(evt);
            }
        });
        scrollItens.setViewportView(arvoreObjetos);

        tabPaneItens.addTab("Itens", scrollItens);

        splitEsquerdo.setTopComponent(tabPaneItens);

        tabelaMesRef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mês", "Ano"
            }
        ));
        scrollMesRef.setViewportView(tabelaMesRef);

        tabPaneMesRef.addTab("Mês Ref.", scrollMesRef);

        splitEsquerdo.setRightComponent(tabPaneMesRef);

        splitCentral.setLeftComponent(splitEsquerdo);

        panelCustos.setLayout(new java.awt.BorderLayout());

        tabelaCustos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollTabelaCustos.setViewportView(tabelaCustos);

        panelCustos.add(scrollTabelaCustos, java.awt.BorderLayout.CENTER);

        panelResumo.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        panelTotalMes.setLayout(new java.awt.GridLayout(2, 2, 2, 10));

        lbTotalPrevistoMes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTotalPrevistoMes.setText("Total Previsto Mes:");
        panelTotalMes.add(lbTotalPrevistoMes);

        txtTotalPrevistoMes.setEnabled(false);
        panelTotalMes.add(txtTotalPrevistoMes);

        lbTotalRealizadoMes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTotalRealizadoMes.setText("Total Realizado Mes:");
        panelTotalMes.add(lbTotalRealizadoMes);

        txtTotalRealizadoMes.setEnabled(false);
        panelTotalMes.add(txtTotalRealizadoMes);

        panelResumo.add(panelTotalMes);

        panelDebitoCredito.setLayout(new java.awt.GridLayout(2, 2, 2, 10));

        lbDebito.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbDebito.setText("Débito:");
        panelDebitoCredito.add(lbDebito);

        txtDebito.setEnabled(false);
        panelDebitoCredito.add(txtDebito);

        lbCredito.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbCredito.setText("Crédito:");
        panelDebitoCredito.add(lbCredito);

        txtCredito.setEnabled(false);
        panelDebitoCredito.add(txtCredito);

        panelResumo.add(panelDebitoCredito);

        panelResumoSaldo.setLayout(new java.awt.GridLayout(2, 2, 2, 10));

        lbSaldoAnterior.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbSaldoAnterior.setText("Saldo Anterior:");
        panelResumoSaldo.add(lbSaldoAnterior);

        txtSaldoAnterior.setEnabled(false);
        panelResumoSaldo.add(txtSaldoAnterior);

        lbSaldoAtual.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbSaldoAtual.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbSaldoAtual.setText("Saldo Atual:");
        panelResumoSaldo.add(lbSaldoAtual);

        txtSaldoAtual.setEnabled(false);
        panelResumoSaldo.add(txtSaldoAtual);

        panelResumo.add(panelResumoSaldo);

        panelCustos.add(panelResumo, java.awt.BorderLayout.SOUTH);

        tabPaneMovimentacao.addTab("Movimentacao", panelCustos);

        splitCentral.setRightComponent(tabPaneMovimentacao);

        internalCentralFrame.getContentPane().add(splitCentral);

        internalCentralFrame.setBounds(770, 210, -1, -1);
        desktopPane.add(internalCentralFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        try {
            internalCentralFrame.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusBar.setPreferredSize(new java.awt.Dimension(100, 22));
        statusBar.setLayout(new java.awt.GridLayout(1, 5));

        statusPanelIdentificacao.setLayout(new java.awt.BorderLayout());

        lbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/user.png"))); // NOI18N
        lbUsuario.setText("Usuario Ativo:");
        lbUsuario.setMaximumSize(new java.awt.Dimension(100, 16));
        lbUsuario.setPreferredSize(new java.awt.Dimension(140, 14));
        statusPanelIdentificacao.add(lbUsuario, java.awt.BorderLayout.WEST);

        lbUsuarioAtivo.setText("Não Logado");
        statusPanelIdentificacao.add(lbUsuarioAtivo, java.awt.BorderLayout.CENTER);

        statusBar.add(statusPanelIdentificacao);

        lbAvisos.setForeground(new java.awt.Color(204, 51, 0));
        lbAvisos.setText("Avisos");

        javax.swing.GroupLayout statusPanelAvisosLayout = new javax.swing.GroupLayout(statusPanelAvisos);
        statusPanelAvisos.setLayout(statusPanelAvisosLayout);
        statusPanelAvisosLayout.setHorizontalGroup(
            statusPanelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelAvisosLayout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(lbAvisos)
                .addContainerGap())
        );
        statusPanelAvisosLayout.setVerticalGroup(
            statusPanelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelAvisosLayout.createSequentialGroup()
                .addComponent(lbAvisos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statusBar.add(statusPanelAvisos);

        lbMensagens.setForeground(new java.awt.Color(0, 102, 204));
        lbMensagens.setText("Mensagens");

        javax.swing.GroupLayout statusPanelMensagensLayout = new javax.swing.GroupLayout(statusPanelMensagens);
        statusPanelMensagens.setLayout(statusPanelMensagensLayout);
        statusPanelMensagensLayout.setHorizontalGroup(
            statusPanelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelMensagensLayout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(lbMensagens)
                .addContainerGap())
        );
        statusPanelMensagensLayout.setVerticalGroup(
            statusPanelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelMensagensLayout.createSequentialGroup()
                .addComponent(lbMensagens)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statusBar.add(statusPanelMensagens);

        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        toolBar.setRollover(true);

        tbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/application_form.png"))); // NOI18N
        tbNovo.setFocusable(false);
        tbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNovoActionPerformed(evt);
            }
        });
        toolBar.add(tbNovo);

        tbAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/folder_page.png"))); // NOI18N
        tbAbrir.setFocusable(false);
        tbAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAbrirActionPerformed(evt);
            }
        });
        toolBar.add(tbAbrir);

        tbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/disk.png"))); // NOI18N
        tbSalvar.setEnabled(false);
        tbSalvar.setFocusable(false);
        tbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbSalvar);
        toolBar.add(jSeparator1);

        tbUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/arrow_undo.png"))); // NOI18N
        tbUndo.setEnabled(false);
        tbUndo.setFocusable(false);
        tbUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbUndo);

        tbRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/arrow_redo.png"))); // NOI18N
        tbRedo.setEnabled(false);
        tbRedo.setFocusable(false);
        tbRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbRedo);
        toolBar.add(jSeparator2);

        tbConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/wrench.png"))); // NOI18N
        tbConfigurar.setFocusable(false);
        tbConfigurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbConfigurar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbConfigurar);
        toolBar.add(jSeparator3);

        tbCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/application_view_tile.png"))); // NOI18N
        tbCategorias.setEnabled(false);
        tbCategorias.setFocusable(false);
        tbCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbCategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCategoriasActionPerformed(evt);
            }
        });
        toolBar.add(tbCategorias);

        tbMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/date.png"))); // NOI18N
        tbMes.setEnabled(false);
        tbMes.setFocusable(false);
        tbMes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbMes);

        tbTipoConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_dollar.png"))); // NOI18N
        tbTipoConta.setEnabled(false);
        tbTipoConta.setFocusable(false);
        tbTipoConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbTipoConta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbTipoConta);
        toolBar.add(jSeparator4);

        tbReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_add.png"))); // NOI18N
        tbReceita.setEnabled(false);
        tbReceita.setFocusable(false);
        tbReceita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbReceita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(tbReceita);

        tbCusto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_delete.png"))); // NOI18N
        tbCusto.setEnabled(false);
        tbCusto.setFocusable(false);
        tbCusto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbCusto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCustoActionPerformed(evt);
            }
        });
        toolBar.add(tbCusto);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        menuArquivo.setText("Arquivo");

        mnNovoDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/application_form_add.png"))); // NOI18N
        mnNovoDocumento.setText("Novo...");
        mnNovoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNovoDocumentoActionPerformed(evt);
            }
        });
        menuArquivo.add(mnNovoDocumento);

        mnAbrirDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/folder_page.png"))); // NOI18N
        mnAbrirDocumento.setText("Abrir...");
        mnAbrirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAbrirDocumentoActionPerformed(evt);
            }
        });
        menuArquivo.add(mnAbrirDocumento);

        mnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/disk.png"))); // NOI18N
        mnSalvar.setText("Salvar");
        mnSalvar.setEnabled(false);
        menuArquivo.add(mnSalvar);

        mnSalvarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/disk_multiple.png"))); // NOI18N
        mnSalvarComo.setText("Salvar Como...");
        mnSalvarComo.setEnabled(false);
        menuArquivo.add(mnSalvarComo);

        mnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/door_out.png"))); // NOI18N
        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        menuArquivo.add(mnSair);

        menuBar.add(menuArquivo);

        menuCadastros.setText("Cadastros");

        mnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/group.png"))); // NOI18N
        mnUsuarios.setText("Usuarios");
        mnUsuarios.setEnabled(false);
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        menuCadastros.add(mnUsuarios);

        mnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/application_view_tile.png"))); // NOI18N
        mnCategorias.setText("Categoria");
        mnCategorias.setEnabled(false);
        mnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCategoriasActionPerformed(evt);
            }
        });
        menuCadastros.add(mnCategorias);

        mnMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/date.png"))); // NOI18N
        mnMes.setText("Mês Referencia");
        mnMes.setEnabled(false);
        menuCadastros.add(mnMes);

        mnTipoConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_dollar.png"))); // NOI18N
        mnTipoConta.setText("Tipos de Conta");
        mnTipoConta.setEnabled(false);
        menuCadastros.add(mnTipoConta);

        menuBar.add(menuCadastros);

        menuLancamentos.setText("Lancamentos");

        mnCustos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_delete.png"))); // NOI18N
        mnCustos.setText("Custo");
        mnCustos.setEnabled(false);
        mnCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCustosActionPerformed(evt);
            }
        });
        menuLancamentos.add(mnCustos);

        mnReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/money_add.png"))); // NOI18N
        mnReceita.setText("Receita");
        mnReceita.setEnabled(false);
        mnReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReceitaActionPerformed(evt);
            }
        });
        menuLancamentos.add(mnReceita);

        menuBar.add(menuLancamentos);

        menuAjuda.setText("Ajuda");

        mnConteudo.setText("Conteudo...");
        menuAjuda.add(mnConteudo);

        mnSobre.setText("Sobre PFinance");
        menuAjuda.add(mnSobre);

        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnNovoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNovoDocumentoActionPerformed
        this.novoDocumento();
    }//GEN-LAST:event_mnNovoDocumentoActionPerformed

    private void mnCustosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCustosActionPerformed
        // TODO add your handling code here:
        this.gerCaixa.novoLancamento();
    }//GEN-LAST:event_mnCustosActionPerformed

    private void mnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuariosActionPerformed
        // TODO add your handling code here:
        final TabelaUsuario usrList = new TabelaUsuario();
        usrList.init();
        desktopPane.add(usrList);
        usrList.setVisible(true);
    }//GEN-LAST:event_mnUsuariosActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void mnAbrirDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAbrirDocumentoActionPerformed
        // TODO add your handling code here:
        this.gerDocumento.selecionaDocumento();
    }//GEN-LAST:event_mnAbrirDocumentoActionPerformed

    private void tbCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCustoActionPerformed

    private void tbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNovoActionPerformed
        // TODO add your handling code here:
        this.mnNovoDocumentoActionPerformed(evt);
    }//GEN-LAST:event_tbNovoActionPerformed

    private void tbAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAbrirActionPerformed
        // TODO add your handling code here:
        this.mnAbrirDocumentoActionPerformed(evt);
    }//GEN-LAST:event_tbAbrirActionPerformed

    private void mnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCategoriasActionPerformed
        // TODO add your handling code here:
        this.gerObjetos.novaCategoria();
    }//GEN-LAST:event_mnCategoriasActionPerformed

    private void tbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCategoriasActionPerformed
        // TODO add your handling code here:
        this.mnCategoriasActionPerformed(evt);
    }//GEN-LAST:event_tbCategoriasActionPerformed

    private void arvoreObjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arvoreObjetosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_arvoreObjetosMouseClicked

    private void mnReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReceitaActionPerformed
        // TODO add your handling code here:
        final FormLancamentoRapido shortCost = new FormLancamentoRapido();
        desktopPane.add(shortCost);
        shortCost.setVisible(true);
    }//GEN-LAST:event_mnReceitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            // Inicia o sistema
            public void run() {
                PFinanceMain pfMain = new PFinanceMain();
                pfMain.setExtendedState(PFinanceMain.MAXIMIZED_BOTH);
                // inicia a area de trabalho
                pfMain.iniciaAreaTrabalho();
                // mostra a interface
                pfMain.setVisible(true);
                // autenticacao
                if (pfMain.login()) {
                    // inicia aplicacao
                    pfMain.init();
                } else {
                    System.exit(0);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvoreObjetos;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JInternalFrame internalCentralFrame;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLabel lbAvisos;
    private javax.swing.JLabel lbCredito;
    private javax.swing.JLabel lbDebito;
    private javax.swing.JLabel lbMensagens;
    private javax.swing.JLabel lbSaldoAnterior;
    private javax.swing.JLabel lbSaldoAtual;
    private javax.swing.JLabel lbTotalPrevistoMes;
    private javax.swing.JLabel lbTotalRealizadoMes;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbUsuarioAtivo;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuLancamentos;
    private javax.swing.JMenuItem mnAbrirDocumento;
    private javax.swing.JMenuItem mnCategorias;
    private javax.swing.JMenuItem mnConteudo;
    private javax.swing.JMenuItem mnCustos;
    private javax.swing.JMenuItem mnMes;
    private javax.swing.JMenuItem mnNovoDocumento;
    private javax.swing.JMenuItem mnReceita;
    private javax.swing.JMenuItem mnSair;
    private javax.swing.JMenuItem mnSalvar;
    private javax.swing.JMenuItem mnSalvarComo;
    private javax.swing.JMenuItem mnSobre;
    private javax.swing.JMenuItem mnTipoConta;
    private javax.swing.JMenuItem mnUsuarios;
    private javax.swing.JPanel panelCustos;
    private javax.swing.JPanel panelDebitoCredito;
    private javax.swing.JPanel panelResumo;
    private javax.swing.JPanel panelResumoSaldo;
    private javax.swing.JPanel panelTotalMes;
    private javax.swing.JScrollPane scrollItens;
    private javax.swing.JScrollPane scrollMesRef;
    private javax.swing.JScrollPane scrollTabelaCustos;
    private javax.swing.JSplitPane splitCentral;
    private javax.swing.JSplitPane splitEsquerdo;
    private javax.swing.JPanel statusBar;
    private javax.swing.JPanel statusPanelAvisos;
    private javax.swing.JPanel statusPanelIdentificacao;
    private javax.swing.JPanel statusPanelMensagens;
    private javax.swing.JTabbedPane tabPaneItens;
    private javax.swing.JTabbedPane tabPaneMesRef;
    private javax.swing.JTabbedPane tabPaneMovimentacao;
    private javax.swing.JTable tabelaCustos;
    private javax.swing.JTable tabelaMesRef;
    private javax.swing.JButton tbAbrir;
    private javax.swing.JButton tbCategorias;
    private javax.swing.JButton tbConfigurar;
    private javax.swing.JButton tbCusto;
    private javax.swing.JButton tbMes;
    private javax.swing.JButton tbNovo;
    private javax.swing.JButton tbReceita;
    private javax.swing.JButton tbRedo;
    private javax.swing.JButton tbSalvar;
    private javax.swing.JButton tbTipoConta;
    private javax.swing.JButton tbUndo;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtDebito;
    private javax.swing.JTextField txtSaldoAnterior;
    private javax.swing.JTextField txtSaldoAtual;
    private javax.swing.JTextField txtTotalPrevistoMes;
    private javax.swing.JTextField txtTotalRealizadoMes;
    // End of variables declaration//GEN-END:variables

    /**
     * Habilita e desabilita o contexto de opcoes (Menu e toolbar) da aplicacao
     * 
     * @param habilita
     */
    private void habilitaOpcoes(boolean habilita) {
        tbSalvar.setEnabled(habilita);
        tbCategorias.setEnabled(habilita);
        tbMes.setEnabled(habilita);
        tbTipoConta.setEnabled(habilita);
        tbReceita.setEnabled(habilita);
        tbCusto.setEnabled(habilita);
        mnSalvar.setEnabled(habilita);
        mnSalvarComo.setEnabled(habilita);
        mnCategorias.setEnabled(habilita);
        mnMes.setEnabled(habilita);
        mnTipoConta.setEnabled(habilita);
        mnReceita.setEnabled(habilita);
        mnCustos.setEnabled(habilita);
    }

    /**
     *  Inicializa a area de trabalho
     */
    private void iniciaAreaTrabalho() {
        // Desabilita opcoes
        this.habilitaOpcoes(false);
    }

    /**
     * Invoca a interface de autenticacao da aplicacao.
     * @return True se a autenticacao obteve sucesso
     */
    private boolean login() {
        FormLogin formLogin = new FormLogin(this, true);
        formLogin.setLocationRelativeTo(null);
        formLogin.setVisible(true);
        if (formLogin.isLogado()) {
            // se sucesso, configura o ambiente, iniciando a sessao
            this.createSession(formLogin.getUsuario());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Configura inicial da sessao, iniciando os responsaveis pelo recursos
     * visuais do sistema.
     * @param usuario
     */
    private void createSession(Usuario usuario) {
        // Invoca a fabrica da sessao em primeira instancia, setando usuario
        gerSessao = FabricaGerenciador.getInstancia().get(GerenciadorSessao.class);
        gerSessao.setUsuarioAtivo(usuario);

        /// Inicia os responsaveis pelos recursos principais e atribui-os ao
        /// gerenciador da sessao

        // Inicia responsavel pelos recursos intrinsecos a janela principal
        Principal principal = new Principal(this, this.tabPaneMovimentacao);
        gerSessao.setPrincipal(principal);

        // Inicia responsavel pelos recursos do Caixa
        TabelaCaixa tabCaixa = new TabelaCaixa();
        tabCaixa.setTabela(tabelaCustos);
        tabCaixa.setCampoCredito(txtCredito);
        tabCaixa.setCampoDebito(txtDebito);
        tabCaixa.setCampoSaldoAnterior(txtSaldoAnterior);
        tabCaixa.setCampoSaldoAtual(txtSaldoAtual);
        tabCaixa.setCampoTotalPrevistoMes(txtTotalPrevistoMes);
        tabCaixa.setCampoTotalRealizadoMes(txtTotalRealizadoMes);
        gerSessao.setTabelaCaixa(tabCaixa);

        // Inicia responsavel pelos recursos da arvore de objetos
        ArvoreObjetos arvObjetos = new ArvoreObjetos(arvoreObjetos);
        gerSessao.setArvoreObjetos(arvObjetos);

        // Inicia responsavel pelao tabela de mes ref
        TabelaMesRef tabMesRef = new TabelaMesRef(tabelaMesRef);
        gerSessao.setTabelaMesRef(tabMesRef);

        // Inicia responsavel pelos recursos da barra de status
        BarraStatus barraStatus = new BarraStatus(lbAvisos, lbMensagens, lbUsuarioAtivo);
        gerSessao.setBarraStatus(barraStatus);

        // Inicializa a sessao
        gerSessao.inicializa();
    }

    /**
     * Inicia a aplicacao, com o usuario ativo, invocando a selecao dos
     * documentos do usuario
     *
     */
    private void init() {
        // Inicia os gerenciadores
        this.gerDocumento = FabricaGerenciador.getInstancia().get(GerenciadorDocumento.class);
        this.gerDocumento.setTopLevelWidget(this);
        this.gerCaixa = FabricaGerenciador.getInstancia().get(GerenciadorCaixa.class);
        this.gerCaixa.setTopLevelWidget(this);
        this.gerObjetos = FabricaGerenciador.getInstancia().get(GerenciadorObjetos.class);
        this.gerObjetos.setTopLevelWidget(this);

        // habilita o menu e toolbar
        this.habilitaOpcoes(true);

        // Invoca a selecao de documentos
        if (this.gerDocumento.selecionaDocumento()) {
            this.carregaDocumento();
        }
    }

    private void carregaDocumento() {
        // Tenta encontrar um mes de ref
        MesRef mesRef = this.gerCaixa.getUltimoMesRef();

        if (mesRef != null) {
            this.gerSessao.setMesRefAtivo(mesRef);
        } else {
            this.gerSessao.getBarraStatus().setAvisos("E' necessario Informar o Mes de Referencia");
        }
        this.gerSessao.atualizarBarraStatus();
        this.gerSessao.atualizaSessao();
    }

    public boolean novoDocumento() {
        return this.gerDocumento.novoDocumento();
    }
}