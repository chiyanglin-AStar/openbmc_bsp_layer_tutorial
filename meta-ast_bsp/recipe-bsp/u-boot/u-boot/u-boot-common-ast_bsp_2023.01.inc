HOMEPAGE = "https://github.com/HewlettPackard/gxp-uboot"
DEPENDS += "flex-native bison-native bc-native"

LICENSE = "GPLv2+"
# this LICENSE md5 number is HPE , need to change
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
# 
SRCREV = "1ded9fa3a26262efa12aa316f66c73298a84d838"

UBRANCH = "v2016.07-aspeed-openbmc"
SRC_URI = "git://git@github.com/openbmc/u-boot.git;branch=${UBRANCH};protocol=https"



S = "${WORKDIR}/git"

PV = "v2023.01+git${SRCPV}"
