/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Connexion;
import com.entities.Marque;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mbock
 */
@Path("controllermarque")
public class MarqueController {

    @GET
    @Produces({"application/json"})
    @Path("/listemarques")
    public ArrayList<Marque> listemarques() {

        ArrayList<Marque> listemarque = new ArrayList<>();
        int existe = 0;
        String statut = "actif";

        try {
            Statement statemarque = Connexion.seconnecter().createStatement();
            ResultSet resultstatemarque = statemarque.executeQuery(com.dao.Marquerequest.listemarques(statut));

            while (resultstatemarque.next()) {
                existe = 1;

                Marque marque = new Marque();

                marque.setIdmarque(resultstatemarque.getInt("idmarque"));
                marque.setNommarque(resultstatemarque.getString("nommarque"));
                marque.setImagemarque(resultstatemarque.getString("imagemarque"));
                marque.setPaysmarque(resultstatemarque.getString("paysmarque"));
                marque.setStatutmarque(resultstatemarque.getString("statutmarque"));
                listemarque.add(marque);
            }
            if(existe == 0){
                Marque marque = new Marque();
                marque.setIdmarque(0);
                listemarque.add(marque);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete " + e.getMessage());
        }

        return listemarque;
    }

    @GET
    @Produces({"application/json"})
    @Path("/singlemarque")
    public Marque singlemarque(@QueryParam("idmarque") int idmarque) throws SQLException{
        
        Marque marque = null;
        String statut ="actif";
        
        try{
            Statement statemarque = Connexion.seconnecter().createStatement();
            ResultSet resultstatemarque = statemarque.executeQuery(com.dao.Marquerequest.singlemarque(statut,idmarque));
            
            while(resultstatemarque.next()){
                marque = new Marque();
                
                marque.setIdmarque(resultstatemarque.getInt("idmarque"));
                marque.setNommarque(resultstatemarque.getString("nommarque"));
                marque.setPaysmarque(resultstatemarque.getString("paysmarque"));
                marque.setImagemarque(resultstatemarque.getString("imagemarque"));
                marque.setStatutmarque(resultstatemarque.getString("statutmarque"));
            }
            if(marque == null){
                marque = new Marque();
                marque.setIdmarque(0);
            }
            
        }catch(SQLException e){
            System.out.println("erreur de la requete au niveau de "+ e.getMessage());
        }
        
        return marque;
    }
    
    @POST
    @Produces({"application/json"})
    @Path("ajoutermarque")
    public Marque ajoutermarque(Marque marqueparam) throws SQLException{
        
        Marque marque = null;
        
        Statement statemarque = Connexion.seconnecter().createStatement();
        statemarque.executeUpdate(com.dao.Marquerequest.ajoutermarque(marqueparam),Statement.RETURN_GENERATED_KEYS);
        try(ResultSet resultstatemarque = statemarque.getGeneratedKeys()){
            while(resultstatemarque.next()){
                marque = new Marque();
                int idmarque = resultstatemarque.getInt(1);
                marque.setIdmarque(idmarque);
            }
        
        }catch(SQLException e){
            System.out.println("erreur au niveau de "+ e.getMessage());
        }
        
        return marque;
    }
}
