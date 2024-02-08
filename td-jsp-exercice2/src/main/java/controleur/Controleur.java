package controleur;

import facade.FacadeParis;
import facade.FacadeParisStaticImpl;
import facade.exceptions.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.Util;
import modele.Match;
import modele.Pari;
import modele.Utilisateur;

import javax.print.attribute.standard.Destination;
import javax.xml.crypto.dsig.XMLObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "controleur", urlPatterns="/pel/*")
public class Controleur extends HttpServlet {
    private static final String CONNEXION = "connexion";
    private static final String DECONNEXION = "deconnexion";
    private static final String HOME = "home";
    private static final String PARISOUVERT = "parisouvert";
    private static final String RETOURAUMENU = "retouraumenu";
    private static final String PARIERMONTANT = "pariermontant";
    private static final String PARICONFIRME = "parisconfirme";
    private static final String MESPARIS = "mesparis";
    private static final String ANNULERPARI = "annulerpari";







    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String parties[] = uri.split("/");
        String cleNavigation = parties[parties.length - 1];
        String destination = "/WEB-INF/pel/home.jsp)";
        FacadeParisStaticImpl facade = (FacadeParisStaticImpl) this.getServletContext().getAttribute("facade");

        switch (cleNavigation){

            case DECONNEXION: {
                Utilisateur user = (Utilisateur) req.getSession().getAttribute("user");
                facade.deconnexion(user.getLogin());
                req.getSession().invalidate();
                destination = "/WEB-INF/pel/home.jsp";
                break;
            }
            case HOME: {
                destination = "/WEB-INF/pel/home.jsp";
                break;
            }
            case PARISOUVERT: {
                req.setAttribute("matchs",facade.getMatchsPasCommences());
                destination = "/WEB-INF/pel/parisouvert.jsp";
                break;
            }
            case RETOURAUMENU: {
                destination = "/WEB-INF/pel/connexion.jsp";
                break;
            }
            case PARIERMONTANT:
                long idMatch = Long.valueOf( req.getParameter("idMatch"));
                Match match =  facade.getMatch(idMatch);
                req.getSession().setAttribute("match",match);
                destination= "/WEB-INF/pel/pariermontant.jsp";
                break;
            case MESPARIS:
                Collection<Pari> mespari = facade.getAllParis();
                req.setAttribute("pari",mespari);
                destination= "/WEB-INF/pel/mesparis.jsp";
                break;
            case ANNULERPARI:
                Utilisateur user= (Utilisateur) req.getSession().getAttribute("user");
                long idPari = Long.valueOf( req.getParameter("idPari"));
                try {
                    Pari pari= facade.getPari(idPari);
                    facade.annulerPari(user.getLogin(),idPari);
                    req.setAttribute("pari",pari);
                    destination= "/WEB-INF/pel/annulerparis.jsp";
                } catch (OperationNonAuthoriseeException e) {
                    Collection<Pari> mesparis = facade.getAllParis();
                    req.setAttribute("pari",mesparis);
                    String erreur = "Le pari ne peut pas être annulé! ";
                    req.setAttribute("erreur", erreur);
                    destination="/WEB-INF/pel/mesparis.jsp";
                }
                break;
            default: {
                PrintWriter err = resp.getWriter();
                err.write("<html><body><h3>failed to reach :</h3><h3>" + uri + "</h3></body></html>");
                break;
            }
        }

        this.getServletContext()
                .getRequestDispatcher(destination)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String parties[] = uri.split("/");
        String cleNavigation = parties[parties.length - 1];
        String destination = "/WEB-INF/pel/home.jsp)";
        FacadeParisStaticImpl facade = (FacadeParisStaticImpl) this.getServletContext().getAttribute("facade");

        switch (cleNavigation){
            case CONNEXION:
                String pseudo =req.getParameter("pseudo");
                String mdp=req.getParameter("password");
                try{
                    Utilisateur utilisateur=facade.connexion(pseudo,mdp);
                    req.getSession().setAttribute("user",utilisateur);
                    req.getSession().setAttribute("password",utilisateur.getPassword());
                    destination= "/WEB-INF/pel/connexion.jsp";
                } catch (UtilisateurDejaConnecteException  e) {
                    destination= "/WEB-INF/pel/home.jsp";
                    String erreur = "Utilisateur deja connecte";
                    req.setAttribute("erreur", erreur);
                }catch (InformationsSaisiesIncoherentesException e){
                    destination= "/WEB-INF/pel/home.jsp";
                    String erreur = "Informations saisie incorrecte";
                    req.setAttribute("erreur", erreur);
                }
                break;
            case PARICONFIRME:
                String verdict= req.getParameter("resultat");
                double montant= Double.valueOf(req.getParameter("montant"));
                Utilisateur user= (Utilisateur) req.getSession().getAttribute("user");
                Match match= (Match) req.getSession().getAttribute("match");
                try {
                    long pari = facade.parier(user.getLogin(), match.getIdMatch(), verdict, montant);
                    req.setAttribute("pari",facade.getPari(pari));
                    destination="/WEB-INF/pel/parisconfirme.jsp";
                } catch (MatchClosException e) {
                    String erreur = "Match clos ";
                    req.setAttribute("erreur", erreur);
                    destination="/WEB-INF/pel/pariermontant.jsp";
                } catch (ResultatImpossibleException e) {
                    String erreur = "Resultat impossible ";
                    req.setAttribute("erreur", erreur);
                    destination="/WEB-INF/pel/pariermontant.jsp";
                } catch (MontantNegatifOuNulException e) {
                    String erreur = "Montant negatif ";
                    req.setAttribute("erreur", erreur);
                    destination="/WEB-INF/pel/pariermontant.jsp";
                }
                break;
            default:
                PrintWriter err = resp.getWriter();
                err.write("<html><body><h3>failed to reach :</h3><h3>"+uri+"</h3></body></html>");
                break;
        }
        this.getServletContext()
                .getRequestDispatcher(destination)
                .forward(req, resp);
    }


}
