SUMMARY = "Utilities for transponder & dvb-s/c blindscan"
SECTION = "base"
PRIORITY = "optional"
RDEPENDS_${PN} = "ncurses"

LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGES = "ceryon-blindscan-dvbs-utils ceryon-blindscan-dvbc-utils"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_ceryon-blindscan-dvbs-utils += "virtual/blindscan-dvbs"
RPROVIDES_ceryon-blindscan-dvbc-utils += "virtual/blindscan-dvbc"

SRC_URI = "file://${BLINDSCAN_BINARY} file://tda1002x"


S = "${WORKDIR}"

FILES_ceryon-blindscan-dvbs-utils = "${bindir}/${BLINDSCAN_BINARY}"
FILES_ceryon-blindscan-dvbc-utils = "${bindir}/tda1002x"

do_install() {
    install -d ${D}${bindir}/
    install -m 0755 "${S}/tda1002x" "${D}${bindir}"
    install -m 0755 "${S}/${BLINDSCAN_BINARY}" "${D}${bindir}"
}

do_prepare_recipe_sysroot[noexec] = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
do_compile[noexec] = "1"
deltask do_populate_sysroot
