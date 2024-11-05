package com.mycompany.proyecto2ipc2.resources;

import Principales.MotorPrograma;
import Principales.Revista;
import Usuarios.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;


@Path("explorarRevistas")
public class ObtenerRevistasResource {
    
    //OBTENER TODAS TODAS LAS REVISTAS AL EXPLORAR REVISTAS
    @GET
    @Path("/{nombreUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRevistas(@PathParam("nombreUsuario") String nombreUsuario) {
        
        MotorPrograma motorPrograma = new MotorPrograma(nombreUsuario);
        
        if (motorPrograma.hayRevistasCreadas()) {
            
            Revista[] revistas = motorPrograma.getRevistas();
            motorPrograma.close();
            return Response.ok(revistas).build();

        } else {
            motorPrograma.close();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    //OBTENER REVISTAS PUBLICADAS
    @GET
    @Path("/revistasPublicadas/{nombreAutor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRevistasPublicadas(@PathParam("nombreAutor") String nombreAutor) {
        
        //System.out.println("Recibiendo revistas publicas");
        MotorPrograma motorPrograma = new MotorPrograma(nombreAutor);
        //MotorPrograma motorPrograma = MotorPrograma.getInstance(nombreAutor);
        ArrayList<Revista> revistasPublicadas = motorPrograma.obtenerRevistasPublicadas(nombreAutor);
        
        if (revistasPublicadas != null) {
            //System.out.println("Hay revistas");
            motorPrograma.close();
            return Response.ok(revistasPublicadas).build();
        }
        
        motorPrograma.close();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    //OBTENER REVISTAS SUSCRITAS
    @GET
    @Path("/revistasSuscritas/{nombreUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRevistasSuscritas(@PathParam("nombreUsuario") String nombreUsuario) {
        MotorPrograma motorPrograma = new MotorPrograma(nombreUsuario);
        motorPrograma.obtenerRevistasSuscritas();
        if (motorPrograma.getRevistasSuscritas() != null) {
            
            return Response.ok(motorPrograma.getRevistasSuscritas()).build();
            
        }
        return Response.status(Response.Status.NOT_FOUND).build();
        
        //Regresa a revistas Suscritas
    }
}
