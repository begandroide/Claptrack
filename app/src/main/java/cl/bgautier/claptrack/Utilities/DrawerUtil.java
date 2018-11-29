package cl.bgautier.claptrack.Utilities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;


public class DrawerUtil {

    public static Drawer getDrawer(final Activity activity, Toolbar toolbar) {

        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        if(toolbar.getNavigationIcon() == null)
        {

            //create the drawer and remember the `Drawer` result object
            Drawer result = new DrawerBuilder()
                    .withActivity(activity)
                    //.withAccountHeader(headerResult)
                    .withToolbar(toolbar)
                    .withActionBarDrawerToggle(false)
                    .withActionBarDrawerToggleAnimated(false)
                    .withCloseOnClick(false)
                    .withSelectedItem(-1)
                    .addDrawerItems(
                            //drawerItemTracker,
                            //drawerItemPreferences,
                            //drawerItemManageGroups,
                            //drawerItemWishlist,
                           // drawerItemFind
                            //new DividerDrawerItem(),
                            //drawerItemSettings,
                            //drawerItemAbout,

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            /*if ( drawerItem.getIdentifier() == 2 ) {
                                if (!activity.getLocalClassName().equals("ListEventActivity")) {
                                    Intent intent = new Intent(activity, ListEventActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if ( drawerItem.getIdentifier() == 3 ) {
                                if (!activity.getLocalClassName().equals("CreateAgendaActivity")) {
                                    Intent intent = new Intent(activity, CreateAgendaActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if(drawerItem.getIdentifier() == 1){
                                if (!activity.getLocalClassName().equals("MenuActivity"))
                                {
                                    Intent intent = new Intent(activity, MenuActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if ( drawerItem.getIdentifier() == 4) {
                                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(activity).edit();
                                editor.clear().commit();
                                Intent intent = new Intent(activity, MainActivity.class);
                                view.getContext().startActivity(intent);
                                activity.finish();

                            }*/
                            return true;
                        }
                    })
                    .build();
            return result;

        }else if(toolbar.getNavigationIcon() != null){


            //if you want to update the items at a later time it is recommended to keep it in a variable

            PrimaryDrawerItem drawerItemTracker = new PrimaryDrawerItem().withIdentifier(1)
                    .withName("Tracker").withIcon(GoogleMaterial.Icon.gmd_gamepad);
            PrimaryDrawerItem drawerItemPreferences = new PrimaryDrawerItem().withIdentifier(2)
                    .withName("Preferences").withIcon(GoogleMaterial.Icon.gmd_settings);
            PrimaryDrawerItem drawerItemWishlist = new PrimaryDrawerItem()
                    .withIdentifier(3).withName("Wishlist").withIcon(GoogleMaterial.Icon.gmd_favorite);
            PrimaryDrawerItem drawerItemFind = new PrimaryDrawerItem()
                    .withIdentifier(4).withName("Find a game").withIcon(GoogleMaterial.Icon.gmd_search);


            /*SecondaryDrawerItem drawerItemAbout = new SecondaryDrawerItem().withIdentifier(4)
                    .withName("About").withIcon(GoogleMaterial.Icon.gmd_info);
            SecondaryDrawerItem drawerItemSettings = new SecondaryDrawerItem().withIdentifier(5)
                    .withName("Settings").withIcon(GoogleMaterial.Icon.gmd_settings);*/
            /*SecondaryDrawerItem itemLogOut = new SecondaryDrawerItem().withIdentifier(4)
                    .withName("Log Out").withIcon(GoogleMaterial.Icon.gmd_exit_to_app);*/



            /*AccountHeader headerResult = new AccountHeaderBuilder()
                    .withActivity(activity)
                    .withHeaderBackground(R.drawable.icono_claptrack)
                    .withTextColorRes(R.color.White)
                    .addProfiles(
                            new ProfileDrawerItem()
                                    .withName("Username")
                                    .withEmail("user@user.com")
                                    .withIcon(GoogleMaterial.Icon.gmd_person)
                    )
                    .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                        @Override
                        public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                            return false;
                        }
                    })
                    .build();*/


            //create the drawer and remember the `Drawer` result object
            Drawer result = new DrawerBuilder()
                    .withActivity(activity)
                    //.withAccountHeader(headerResult)
                    .withToolbar(toolbar)
                    .withActionBarDrawerToggle(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withCloseOnClick(true)
                    .withSelectedItem(-1)
                    .addDrawerItems(
                            drawerItemTracker,
                            drawerItemPreferences,
                            //drawerItemManageGroups,
                            drawerItemWishlist,
                            drawerItemFind
                            //new DividerDrawerItem(),
                            //drawerItemSettings,
                            //drawerItemAbout,

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            /*if ( drawerItem.getIdentifier() == 2 ) {
                                if (!activity.getLocalClassName().equals("ListEventActivity")) {
                                    Intent intent = new Intent(activity, ListEventActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if ( drawerItem.getIdentifier() == 3 ) {
                                if (!activity.getLocalClassName().equals("CreateAgendaActivity")) {
                                    Intent intent = new Intent(activity, CreateAgendaActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if(drawerItem.getIdentifier() == 1){
                                if (!activity.getLocalClassName().equals("MenuActivity"))
                                {
                                    Intent intent = new Intent(activity, MenuActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            }else if ( drawerItem.getIdentifier() == 4) {
                                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(activity).edit();
                                editor.clear().commit();
                                Intent intent = new Intent(activity, MainActivity.class);
                                view.getContext().startActivity(intent);
                                activity.finish();

                            }*/
                            return true;
                        }
                    })
                    .build();
            return result;
        }else{
            return null;
        }
    }
}
