package jsf;

import jpa.entities.ProdLevelDetail;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import jpa.session.ProdLevelDetailFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "prodLevelDetailController")
@SessionScoped
public class ProdLevelDetailController implements Serializable {

    @EJB
    private jpa.session.ProdLevelDetailFacade ejbFacade;
    private List<ProdLevelDetail> items = null;
    private ProdLevelDetail selected;

    public ProdLevelDetailController() {
    }

    public ProdLevelDetail getSelected() {
        return selected;
    }

    public void setSelected(ProdLevelDetail selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProdLevelDetailFacade getFacade() {
        return ejbFacade;
    }

    public ProdLevelDetail prepareCreate() {
        selected = new ProdLevelDetail();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ProdLevelDetailCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ProdLevelDetailUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ProdLevelDetailDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProdLevelDetail> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<ProdLevelDetail> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProdLevelDetail> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProdLevelDetail.class)
    public static class ProdLevelDetailControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProdLevelDetailController controller = (ProdLevelDetailController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "prodLevelDetailController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProdLevelDetail) {
                ProdLevelDetail o = (ProdLevelDetail) object;
                return getStringKey(o.getLevel());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProdLevelDetail.class.getName()});
                return null;
            }
        }

    }

}
