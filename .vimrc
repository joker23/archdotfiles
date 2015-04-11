" this file is really just here to gather everything together
"
" author: Steven Zhang
set wrap
source ~/.vim/config/vimrc

augroup java
	au Filetype java source ~/.vim/config/vimrc.java_conf
augroup END

augroup perl
	au Filetype perl source ~/.vim/config/vimrc.perl_conf
augroup END

augroup latex
	au Filetype tex source ~/.vim/config/vimrc.latex_conf
augroup END

augroup cpp
	au FileType cpp source ~/.vim/config/vimrc.cpp_conf
augroup END
