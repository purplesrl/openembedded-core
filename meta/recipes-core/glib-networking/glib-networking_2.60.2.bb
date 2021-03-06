SUMMARY = "GLib networking extensions"
DESCRIPTION = "glib-networking contains the implementations of certain GLib networking features that cannot be implemented directly in GLib itself because of their dependencies."
HOMEPAGE = "https://gitlab.gnome.org/GNOME/glib-networking/"
BUGTRACKER = "http://bugzilla.gnome.org"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SECTION = "libs"
DEPENDS = "glib-2.0"

SRC_URI[archive.md5sum] = "bf46d1208ac00d78a45fbf621d459025"
SRC_URI[archive.sha256sum] = "c022f3d10f55a5b7c31676fb001b4cb6401db8ab9f6e8418c69de00d0f268732"

PACKAGECONFIG ??= "gnutls"

PACKAGECONFIG[gnutls] = "-Dgnutls=enabled,-Dgnutls=disabled,gnutls"
PACKAGECONFIG[libproxy] = "-Dlibproxy=enabled,-Dlibproxy=disabled,libproxy"

EXTRA_OEMESON = "-Dgnome_proxy=disabled"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gettext upstream-version-is-even gio-module-cache

FILES_${PN} += "\
                ${libdir}/gio/modules/libgio*.so \
                ${datadir}/dbus-1/services/ \
                ${systemd_user_unitdir} \
                "
FILES_${PN}-dev += "${libdir}/gio/modules/libgio*.la"
FILES_${PN}-staticdev += "${libdir}/gio/modules/libgio*.a"
