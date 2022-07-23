package models;

import props.Notes;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public interface INote {
    int Insert(Notes notes);
    int Update(Notes notes, int nid);
    int Delete(int nid);
    List<Notes> noteList();
    DefaultTableModel notesTableModel();
}
