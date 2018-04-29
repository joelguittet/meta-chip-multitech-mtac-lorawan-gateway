SUMMARY = "libmpsse"
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mpsse.h;md5=ff900af321d7f43af308655481cb842a"

DEPENDS_${PN} = "libftdi"

do_compile[depends] = "libftdi:do_populate_sysroot"

PR = "r0"

SRCREV = "a2eafa24a3446a711b13523ec06c17b5a1c6cdc1"

SRC_URI = " \
    git://github.com/devttys0/libmpsse.git;protocol=git;branch=master \
"

inherit autotools

S = "${WORKDIR}/git/src"
B = "${WORKDIR}/git/src"

EXTRA_OECONF_append = " --disable-python"

CFLAGS += "-I."

ALLOW_EMPTY_${PN} = "1"
