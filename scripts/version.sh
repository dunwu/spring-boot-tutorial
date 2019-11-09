#!/usr/bin/env bash

# ----------------------------------------------------------------------------------
# 控制台颜色
BLACK="\033[1;30m"
RED="\033[1;31m"
GREEN="\033[1;32m"
YELLOW="\033[1;33m"
BLUE="\033[1;34m"
PURPLE="\033[1;35m"
CYAN="\033[1;36m"
RESET="$(tput sgr0)"
# ----------------------------------------------------------------------------------

printf "${PURPLE}"
cat << EOF

# ----------------------------------------------------------------------------------
# 批量修改 maven 项目版本号
# @author: Zhang Peng
# ----------------------------------------------------------------------------------

EOF
printf "${RESET}"

getCurrentVersion() {
currentVersion=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
printf "\n${YELLOW}Current project version is: ${currentVersion}\n\n${RESET}"
}

modes=("自动升级版本号" "手动输入版本号" "退出")
main() {

PS3="请选择模式："
select item in ${modes[@]}
do
case ${item} in
  "自动升级版本号")
    printf "\n"
    autoIncreaseVersion
    exit 0 ;;
  "手动输入版本号")
    printf "\n"
    read -p "请输入版本号：" version
    changeVersion ${version}
    exit 0 ;;
  "退出")
    exit 0 ;;
  *)
    printf "${RED}\n【错误】未知选项${RESET}\n\n"
    main ;;
esac
break
done
}

calcVersion() {
oper=$1

# 将版本号化为数字数组
temp=`echo ${currentVersion%-SNAPSHOT}`
OLD_IFS="$IFS"
IFS="."
array=(${temp})
IFS="$OLD_IFS"

# 将数组最后一个元素（即末位版本号）根据 oper 加一或减一
lastIndex=`expr ${#array[*]} - 1`
value=${array[${lastIndex}]}
array[${lastIndex}]=`expr ${value} ${oper} 1`

# 拼接改变后的数字数组，形成最终版本号
releaseVersion="${array[0]}"
for (( i = 1; i < ${#array[*]}; i ++ )); do
  releaseVersion="${releaseVersion}.${array[$i]}"
done
snapshotVersion="${releaseVersion}-SNAPSHOT"
}

types=("升级（RELEASE版本）" "升级（SNAPSHOT版本）" "降级（RELEASE版本）" "降级（SNAPSHOT版本）")
autoIncreaseVersion() {

PS3="请选择版本："
select item in ${types[@]}
do
case ${item} in
  "升级（RELEASE版本）")
    calcVersion "+"
    changeVersion ${releaseVersion} ;;
  "升级（SNAPSHOT版本）")
    calcVersion "+"
    changeVersion ${snapshotVersion} ;;
  "降级（RELEASE版本）")
    calcVersion "-"
    changeVersion ${releaseVersion} ;;
  "降级（SNAPSHOT版本）")
    calcVersion "-"
    changeVersion ${snapshotVersion} ;;
  *)
    printf "${RED}unknown option\n${RESET}"
    autoIncreaseVersion ;;
esac
break
done
}

changeVersion() {
mvn versions:set -DnewVersion=$1
mvn versions:commit
getCurrentVersion
}

# ----------------------------------------------------------------------------------

cd ..
currentVersion=''
getCurrentVersion
main
