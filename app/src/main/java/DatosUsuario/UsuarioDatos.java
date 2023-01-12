package DatosUsuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import BD_Usuario.UsuarioDb;
import Entidades.Usuario;

public class UsuarioDatos extends UsuarioDb {


    Context context;

    public UsuarioDatos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario( String nombre, String usuario, String clave){

        long id = 0;

        try {
            UsuarioDb dbUsu = new UsuarioDb(context);
            SQLiteDatabase db = dbUsu.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("user", usuario);
            values.put("clave", clave);

            id = db.insert(TABLE_NOMBRE, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public Usuario obtenerUsuario(String user, String clave) {

        UsuarioDb dbUser = new UsuarioDb(context);
        SQLiteDatabase db = dbUser.getWritableDatabase();

        Usuario usuario = null;
        Cursor cursorUsuario;

        cursorUsuario = db.rawQuery("SELECT * FROM " + TABLE_NOMBRE + " WHERE user = '" + user + "' and clave = '" + clave + "' LIMIT 1", null);

        if (cursorUsuario.moveToFirst()) {
            usuario = new Usuario();
            usuario.setId(cursorUsuario.getInt(0));
            usuario.setNombre(cursorUsuario.getString(1));
            usuario.setUser(cursorUsuario.getString(2));
            usuario.setClave(cursorUsuario.getString(3));
        }

        cursorUsuario.close();

        return usuario;
    }


}
