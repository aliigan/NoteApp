package models;

import props.Notes;
import utils.DB;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteImpl implements INote {
    DB db = new DB();

    @Override
    public int Insert(Notes notes) {
        int status = 0;
        try {
            String sql = "insert into notes values(null,?,?,?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, notes.getTitle());
            pre.setString(2, notes.getDetail());
            pre.setString(3, notes.getDate());
            status = pre.executeUpdate();
        }catch (Exception ex){
            System.err.println("Insert Error : " +ex);
        }finally {
            db.close();
        }
        return status;
    }

    @Override
    public int Update(Notes notes, int nid) {
        int status = 0;
        try {
            String sql = " update notes set title= ?, detail= ?, date= ? where nid=?  ";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1,notes.getTitle());
            pre.setString(2,notes.getDetail());
            pre.setString(3,notes.getDate());
            pre.setInt(4,nid);
            status = pre.executeUpdate();

        }
        catch (Exception ex){
            System.err.println("Update Error: " + ex);
            if (ex.toString().contains("UNIQUE")){
                status = -1;
            }
        }finally {
            db.close();
        }
        return status;
    }

    @Override
    public int Delete(int nid) {
        int status = 0;
        try {
            String sql = " delete from notes where nid=? ";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,nid);
            status = pre.executeUpdate();
        }
        catch (Exception ex){
            System.err.println("Delete Error: " + ex);
        }finally {
            db.close();
        }
        return status;
    }

    @Override
    public List<Notes> noteList() {
        List<Notes> noteList = new ArrayList<>();
        try {
            String sql = "select * from notes";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int nid = rs.getInt("Nid");
                String title = rs.getString("Title");
                String detail = rs.getString("Detail");
                String date = rs.getString("Date");
                Notes notes = new Notes(nid,title,detail,date);
                noteList.add(notes);
            }
        }catch (Exception exception) {
            System.err.println("NoteList" + exception);
        }finally {
            db.close();
        }
        return noteList;
    }

    @Override
    public DefaultTableModel notesTableModel() {
        List<Notes> lsNotesTable = new ArrayList<>();
        DefaultTableModel notesTable = new DefaultTableModel();
        notesTable.addColumn("Note Number");
        notesTable.addColumn("Title");
        notesTable.addColumn("Detail");
        notesTable.addColumn("Date");
        lsNotesTable = noteList();
        for (Notes item : lsNotesTable) {
            Object[] row = {
                    item.getNid(),
                    item.getTitle(),
                    item.getDetail(),
                    item.getDate()
            };
            notesTable.addRow(row);
        }
        return notesTable;
    }
}
