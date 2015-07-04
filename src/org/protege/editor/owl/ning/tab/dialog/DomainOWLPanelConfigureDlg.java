package org.protege.editor.owl.ning.tab.dialog;

import org.protege.editor.owl.ning.domainOWL.MetaOntology;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
//import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * The dialog to configure the domain owl panel to decide which
 * meta concepts, meta relations, individuals are included in
 * the domain owl panel to create the domain ontology
 *
 * @author Zhu Ning
 * @version 0.1.0
 */
public class DomainOWLPanelConfigureDlg extends JDialog
{
    /**
     * The types for the tables shown in the configure dialog
     */
    private enum TableType
    {
        METACONCEPT_TABLE,
        METARELATION_TABLE,
        INSTANCE_TABLE
    }

    public DomainOWLPanelConfigureDlg()
    {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2));

        JPanel metaCncptPanel =
            createSubConfigPanel(TableType.METACONCEPT_TABLE);
        JPanel metaRelationPanel =
            createSubConfigPanel(TableType.METARELATION_TABLE);
        JPanel instancePanel =
            createSubConfigPanel(TableType.INSTANCE_TABLE);

        mainPanel.add(metaCncptPanel);
        mainPanel.add(metaRelationPanel);
        mainPanel.add(instancePanel);

        JPanel buttonPanel = new JPanel();
        //        JCheckBox checkBox =
        //            new JCheckBox("Not show the dialog next time");
        JButton okBtn = new JButton("OK");
        //        buttonPanel.add(checkBox);
        buttonPanel.add(okBtn);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Create a sub config panel according to different type of meta
     * tables including MetaConcept Table, MetaRelation Table and
     * Instance Table
     * @param tableType The type of the table
     * @return The sub configure panel for the tableType-type table
     */
    private JPanel createSubConfigPanel(TableType tableType)
    {
        String title = null;
        JTable table = null;

        switch (tableType)
        {
        case METACONCEPT_TABLE:
            title = "Meta Concepts:";
            table = new JTable(new MetaConceptConfigTableModel());
            break;
        case METARELATION_TABLE:
            title = "Meta Relations:";
            table = new JTable(new MetaRelationConfigTableModel());
            break;
        case INSTANCE_TABLE:
            title = "Instances:";
            table = new JTable(new InstanceConfigTableModel());
        }

        JPanel configPanel = new JPanel();
        configPanel.setBorder(BorderFactory.createTitledBorder(title));
        configPanel.add(new JScrollPane(table));

        return configPanel;
    }
}